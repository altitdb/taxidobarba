package br.com.taxidobarba.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.business.results.annualsummary.AmountDTO;
import br.com.taxidobarba.business.results.annualsummary.AnnualSummaryDTO;
import br.com.taxidobarba.business.results.annualsummary.SummaryDTO;
import br.com.taxidobarba.domain.CashRegisterCity;
import br.com.taxidobarba.domain.CashRegisterTravel;
import br.com.taxidobarba.repository.CashRegisterCityRepository;
import br.com.taxidobarba.repository.CashRegisterTravelRepository;

@Service
public class AnnualSummaryServiceBean implements AnnualSummaryService{

    private static final Logger LOG = LogManager.getLogger(AnnualSummaryServiceBean.class);
    
    @Autowired
    private CashRegisterCityRepository cashRegisterCityRepository;
    @Autowired
    private CashRegisterTravelRepository cashRegisterTravelRepository;
    
    @Override
    public AnnualSummaryDTO generate() {
        LOG.info("generate...");
        
        List<SummaryDTO> annualSummary = loadAnnualSummary();
        AmountDTO amount = loadAmount(annualSummary);
        
        return new AnnualSummaryDTO.AnnualSummaryBuilder()
                            .withAnnualSummary(annualSummary)
                            .amount(amount)
                            .build();
    }
    
    private List<SummaryDTO> loadAnnualSummary() {
        LOG.info("loadAnnualSummary...");
        
        List<SummaryDTO> annualSummaryList = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate firstDayOfYear = now.with(TemporalAdjusters.firstDayOfYear());

        long begin = System.currentTimeMillis();

        firstDayOfYear.datesUntil(now, Period.ofMonths(1)).forEach(date -> {

            BigDecimal netValueTravel;
            BigDecimal grossValueTravel;
            BigDecimal netValueCity;
            BigDecimal grossValueCity;
            String month = getFormattedDate(date);
            LocalDate lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());

            List<CashRegisterCity> cashRegisterCities = getCashRegistersCities(date, lastDayOfMonth);
            List<CashRegisterTravel> cashRegisterTravels = getCashRegistersTravels(date, lastDayOfMonth);
            
            grossValueCity = cashRegisterCities.stream()
                                      .map(CashRegisterCity::getTotalReceived)
                                      .reduce(BigDecimal.ZERO, BigDecimal::add);
            
            grossValueTravel = cashRegisterTravels.stream()
                                         .map(CashRegisterTravel::getPrice)
                                         .reduce(BigDecimal.ZERO, BigDecimal::add);

            netValueCity = cashRegisterCities.stream()
                                      .map(CashRegisterCity::getPrice)
                                      .reduce(BigDecimal.ZERO, BigDecimal::add);
            
            netValueTravel =  cashRegisterTravels.stream()
                                         .map(CashRegisterTravel::getNetValue)
                                         .reduce(BigDecimal.ZERO, BigDecimal::add);

            SummaryDTO dto = createSummaryDto(grossValueCity.add(grossValueTravel), netValueCity.add(netValueTravel), month);
            
            annualSummaryList.add(dto);
        });

        long end = System.currentTimeMillis();

        LOG.info("Tempo gasto em loadAnnualSummary: {} ms", (end - begin));

        return annualSummaryList;
    }
    
    private SummaryDTO createSummaryDto(BigDecimal grossValue, BigDecimal netValue, String month) {
        return new SummaryDTO.SummaryBuilder()
                .withGrossValue(grossValue)
                .withMonth(month)
                .withNetValue(netValue)
                .build();
    }
    
    private String getFormattedDate(LocalDate date) {
        return String.valueOf(date.format(DateTimeFormatter.ofPattern("MM/yyyy")));
    }
    
    private List<CashRegisterCity> getCashRegistersCities(LocalDate initialDate, LocalDate finalDate){
        return cashRegisterCityRepository.findByDateBetween(initialDate, finalDate);
    }
    
    private List<CashRegisterTravel> getCashRegistersTravels(LocalDate initialDate, LocalDate finalDate){
        return cashRegisterTravelRepository.findByDateBetween(initialDate, finalDate);
    }
    
    private AmountDTO loadAmount(List<SummaryDTO> annualSummary) {
        LOG.info("loadAmount...");
        BigDecimal netValue;
        BigDecimal grossValue;
        
        netValue = annualSummary.stream()
                           .map(SummaryDTO::getNetValue)
                           .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        grossValue = annualSummary.stream()
                            .map(SummaryDTO::getGrossValue)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        return new AmountDTO.AmountBuilder()
                            .withGrossValue(grossValue)
                            .withNetValue(netValue)
                            .build();
    }
    
}

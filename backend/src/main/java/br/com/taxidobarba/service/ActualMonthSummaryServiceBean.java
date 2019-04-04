package br.com.taxidobarba.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.business.results.actualmonth.ActualMonthSummaryDTO;
import br.com.taxidobarba.business.results.actualmonth.ConsumptionDTO;
import br.com.taxidobarba.business.results.actualmonth.KmDTO;
import br.com.taxidobarba.business.results.actualmonth.SummaryDTO;
import br.com.taxidobarba.domain.CashRegisterCity;
import br.com.taxidobarba.domain.CashRegisterTravel;
import br.com.taxidobarba.domain.Fuel;
import br.com.taxidobarba.repository.CashRegisterCityRepository;
import br.com.taxidobarba.repository.CashRegisterTravelRepository;
import br.com.taxidobarba.repository.FuelRepository;

@Service
public class ActualMonthSummaryServiceBean implements ActualMonthSummaryService {

    private static final Logger LOG = LogManager.getLogger(ActualMonthSummaryServiceBean.class);

    @Autowired
    private CashRegisterCityRepository cashCityRepository;
    @Autowired
    private CashRegisterTravelRepository cashTravelRepository;
    @Autowired FuelRepository fuelRepository;
    private List<CashRegisterCity> cashRegisterCities;
    private List<CashRegisterTravel> cashRegisterTravels;
    private List<Fuel> fuels;
    private BigDecimal kmRolledCity;
    private BigDecimal kmRolledTravel;
    private BigDecimal amountKmRolled;
    private Integer amountWorkedDays;

    @Override
    public ActualMonthSummaryDTO generate() {
        initialize();
        SummaryDTO summary = loadSummary();
        KmDTO km = loadKm();
        ConsumptionDTO consumption = loadConsumption();
        return new ActualMonthSummaryDTO.ActualMonthSummaryBuilder()
                                                .withDate(getDate())
                                                .withSummary(summary)
                                                .withKm(km)
                                                .withConsumption(consumption)
                                                .build();
    }

    private void initialize() {
        LocalDate initialDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate finalDate = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        
        LOG.info(String.format("Periodo utilizado nas consultas: [%s] a [%s]", initialDate, finalDate));
        LOG.info("Buscando registros na base...");
        
        cashRegisterCities = cashCityRepository.findByDateBetween(initialDate, finalDate);
        cashRegisterTravels = cashTravelRepository.findByDateBetween(initialDate, finalDate);
        fuels = fuelRepository.findByDateBetween(initialDate, finalDate);
        kmRolledCity = getKmRolledCity();
        kmRolledTravel = getKmRolledTravel();
        amountKmRolled = getAmountKmRolled();
        amountWorkedDays = getAmountWorkedDays();
        
        LOG.info("Qtde registros para cidade: " + cashRegisterCities.size());
        LOG.info("Qtde registros para viagem: " + cashRegisterTravels.size());
        LOG.info("Qtde registros para combustivel: " + fuels.size());
    }
    
    private SummaryDTO loadSummary() {
        LOG.info("Carregando summary...");
        
        BigDecimal netValue = BigDecimal.ZERO;
        BigDecimal grossValue = BigDecimal.ZERO;
        BigDecimal totalPrice = BigDecimal.ZERO;
        BigDecimal expectedValue;

        for (CashRegisterCity city : cashRegisterCities) {
            netValue = netValue.add(city.getPrice());
            grossValue = grossValue.add(city.getTotalReceived());
            totalPrice = totalPrice.add(city.getPrice());
        }

        for (CashRegisterTravel travel : cashRegisterTravels) {
            netValue = netValue.add(travel.getNetValue());
            grossValue = grossValue.add(travel.getPrice());
            totalPrice = totalPrice.add(travel.getPrice());
        }

        expectedValue = amountWorkedDays > 0 ? totalPrice.divide(BigDecimal.valueOf(amountWorkedDays))
                : BigDecimal.ZERO;

        LOG.info("Summary carregado.");
        
        return new SummaryDTO.SummaryBuilder()
                             .withNetValue(netValue)
                             .withGrossValue(grossValue)
                             .withExpectedValue(expectedValue)
                             .build();
    }
    
    private KmDTO loadKm() {
        return new KmDTO.KmBuilder()
                        .withAmountKmRolled(amountKmRolled)
                        .withKmRolledCity(kmRolledCity)
                        .withKmRolledTravel(kmRolledTravel)
                        .build();
    }
    
    private ConsumptionDTO loadConsumption() {
        LOG.info("Carregando consumption...");

        BigDecimal amountLiters = BigDecimal.ZERO;
        BigDecimal litersPerKm = BigDecimal.ZERO;
        BigDecimal averagePriceSpentPerKm = BigDecimal.ZERO;
        BigDecimal amountPriceFuel = BigDecimal.ZERO;
        BigDecimal averageKmPerDay = BigDecimal.ZERO;

        for (Fuel fuel : fuels) {
            amountLiters = amountLiters.add(fuel.getLiters());
            amountPriceFuel = amountPriceFuel.add(fuel.getPrice());
        }

        if(amountKmRolled.compareTo(BigDecimal.ZERO) > 0) {
            litersPerKm = amountLiters.divide(amountKmRolled);
            averagePriceSpentPerKm = amountPriceFuel.divide(amountKmRolled);
        }
        
        if(amountWorkedDays > 0) {
            averageKmPerDay = amountKmRolled.divide(BigDecimal.valueOf(amountWorkedDays));
        }

        LOG.info("Consumption carregado.");
        
        return new ConsumptionDTO.ConsumptionBuilder()
                                 .withAverageKmPerDay(averageKmPerDay)
                                 .withAveragePriceSpentPerKm(averagePriceSpentPerKm)
                                 .build();
    }
    
    private BigDecimal getKmRolledCity() {
        return cashRegisterCities.stream()
                .map(CashRegisterCity::getKm)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    private BigDecimal getKmRolledTravel() {
        return cashRegisterTravels.stream()
                .map(CashRegisterTravel::getKm)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    private BigDecimal getAmountKmRolled() {
        return getKmRolledCity().add(getKmRolledTravel());
    }
    
    private Integer getAmountWorkedDays() {
        Set<LocalDate> setWorkedDays = new HashSet<>();
        cashRegisterCities.stream()
                          .forEach(city -> setWorkedDays.add(city.getDate()));
        cashRegisterTravels.stream()
                           .forEach(travel -> setWorkedDays.add(travel.getDate()));
        return setWorkedDays.size();
    }
    
    private String getDate() {
        return String.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/yyyy")));
    }

}

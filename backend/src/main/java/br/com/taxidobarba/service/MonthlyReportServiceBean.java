package br.com.taxidobarba.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.business.results.monthlyreport.AmountDTO;
import br.com.taxidobarba.business.results.monthlyreport.CashRegisterType;
import br.com.taxidobarba.business.results.monthlyreport.MonthlyReportDTO;
import br.com.taxidobarba.business.results.monthlyreport.ReportDTO;
import br.com.taxidobarba.domain.CashRegisterCity;
import br.com.taxidobarba.domain.CashRegisterTravel;
import br.com.taxidobarba.repository.CashRegisterCityRepository;
import br.com.taxidobarba.repository.CashRegisterTravelRepository;

@Service
public class MonthlyReportServiceBean implements MonthlyReportService {

    private static final Logger LOG = LogManager.getLogger(MonthlyReportServiceBean.class);

    @Autowired
    private CashRegisterCityRepository cashRegisterCityRepository;
    @Autowired
    private CashRegisterTravelRepository cashRegisterTravelRepository;
    private List<CashRegisterCity> cashRegisterCities;
    private List<CashRegisterTravel> cashRegisterTravels;
    private LocalDate initialDate;
    private LocalDate finalDate;

    @Override
    public MonthlyReportDTO generate() {
        LOG.info("generate...");
        initialize();
        List<ReportDTO> report = loadReport();
        AmountDTO amount = loadAmount(report);

        return new MonthlyReportDTO.MonthlyReportBuilder()
                    .withReport(report)
                    .withAmount(amount)
                    .build();
    }

    private void initialize() {
        LOG.info("initialize...");

        initialDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        finalDate = LocalDate.now();

        LOG.info("Periodo utilizado na consulta: {} a {}", initialDate, finalDate);

        cashRegisterCities = cashRegisterCityRepository.findByDateBetween(initialDate, finalDate);
        cashRegisterTravels = cashRegisterTravelRepository.findByDateBetween(initialDate, finalDate);
    }

    private List<ReportDTO> loadReport() {
        LOG.info("loadReport...");

        List<ReportDTO> reports = addRegisteredRecordsToList();
        fillsInDaysWithoutRecords(reports);
        
        return orderedReports(reports);
    }
    
    private AmountDTO loadAmount(List<ReportDTO> reports) {
        LOG.info("loadAmount...");
        BigDecimal amount = reports.stream()
                                   .map(ReportDTO::getValue)
                                   .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new AmountDTO.AmountBuilder()
                        .withAmount(amount)
                        .build();
    }

    private List<ReportDTO> addRegisteredRecordsToList() {
        LOG.info("addRegisteredRecordsToList...");
        
        List<ReportDTO> reports = new ArrayList<>();
        
        cashRegisterCities.stream()
         .forEach(city -> {
            ReportDTO dto = new ReportDTO.ReportBuilder()
                    .withDate(dateFormatted(city.getDate()))
                    .withDriver(city.getDriver().getName())
                    .withKm(city.getKm())
                    .withType(CashRegisterType.CITY)
                    .withValue(city.getPrice())
                    .build();
            
            reports.add(dto);
        });

        cashRegisterTravels.stream()
         .forEach(travel ->{
             ReportDTO dto = new ReportDTO.ReportBuilder()
                     .withDate(dateFormatted(travel.getDate()))
                     .withDriver(travel.getDriver().getName())
                     .withKm(travel.getKm())
                     .withType(CashRegisterType.TRAVEL)
                     .withValue(travel.getPrice())
                     .build();
             
             reports.add(dto);
         });
        
        return reports;
    }
    
    private void fillsInDaysWithoutRecords(List<ReportDTO> reports) {
        LOG.info("fillsInDaysWithoutRecords...");
        
        initialDate.datesUntil(finalDate.plusDays(1), Period.ofDays(1))
            .forEach(date -> 
                Arrays.stream(CashRegisterType.values()).forEach(type -> {
                        
                    if (!hasRecords(reports, date, type)) {
                        ReportDTO dto = new ReportDTO.ReportBuilder()
                                .withDate(dateFormatted(date))
                                .withKm(BigDecimal.ZERO)
                                .withValue(BigDecimal.ZERO)
                                .withType(type)
                                .build();
                        reports.add(dto);
                    }
                        
                })
            );
    }
    
    private List<ReportDTO> orderedReports(List<ReportDTO> reports) {
        return reports.stream()
                .sorted(Comparator.comparing(ReportDTO::getDate))
                .collect(Collectors.toList());
    }
    
    private String dateFormatted(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    private boolean hasRecords(List<ReportDTO> reports, LocalDate date, CashRegisterType type) {
        return reports.stream()
                .anyMatch(report -> report.getDate().equals(dateFormatted(date)) && report.getType().equals(type));
    }
}


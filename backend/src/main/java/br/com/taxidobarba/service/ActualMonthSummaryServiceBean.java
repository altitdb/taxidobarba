package br.com.taxidobarba.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.business.results.actualmonth.ActualMonthSummaryDTO;
import br.com.taxidobarba.business.results.actualmonth.CardCreditDTO;
import br.com.taxidobarba.business.results.actualmonth.CardDTO;
import br.com.taxidobarba.business.results.actualmonth.CardDebitDTO;
import br.com.taxidobarba.business.results.actualmonth.CardSummaryDTO;
import br.com.taxidobarba.business.results.actualmonth.ConsumptionDTO;
import br.com.taxidobarba.business.results.actualmonth.DriverDTO;
import br.com.taxidobarba.business.results.actualmonth.KmDTO;
import br.com.taxidobarba.business.results.actualmonth.SpentDTO;
import br.com.taxidobarba.business.results.actualmonth.SummaryDTO;
import br.com.taxidobarba.domain.CashRegisterCity;
import br.com.taxidobarba.domain.CashRegisterTravel;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.Fuel;
import br.com.taxidobarba.repository.CashRegisterCityRepository;
import br.com.taxidobarba.repository.CashRegisterTravelRepository;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.repository.FuelRepository;

@Service
public class ActualMonthSummaryServiceBean {

    private static final Logger LOG = LogManager.getLogger(ActualMonthSummaryServiceBean.class);

    @Autowired
    private CashRegisterCityRepository cashCityRepository;
    @Autowired
    private CashRegisterTravelRepository cashTravelRepository;
    @Autowired
    private FuelRepository fuelRepository;
    @Autowired
    private DriverRepository driverRepository;
    private List<CashRegisterCity> cashRegisterCities;
    private List<CashRegisterTravel> cashRegisterTravels;
    private List<Fuel> fuels;
    private BigDecimal kmRolledCity;
    private BigDecimal kmRolledTravel;
    private BigDecimal amountKmRolled;
    private Integer amountWorkedDays;
    private BigDecimal amountPriceCity;
    private BigDecimal amountPriceTravel;

    public ActualMonthSummaryDTO generate() {
        initialize();
        
        SummaryDTO summary = loadSummary();
        KmDTO km = loadKm();
        ConsumptionDTO consumption = loadConsumption();
        CardDTO card = loadCard();
        SpentDTO spent = loadSpent();
        List<DriverDTO> driver = loadDriver();
        
        return new ActualMonthSummaryDTO.ActualMonthSummaryBuilder()
                                                .withDate(getDate())
                                                .withSummary(summary)
                                                .withKm(km)
                                                .withConsumption(consumption)
                                                .withCard(card)
                                                .withSpent(spent)
                                                .withDriver(driver)
                                                .build();
    }

    private void initialize() {
        LOG.info("Inicializando registros...");
        
        LocalDate initialDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate finalDate = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        kmRolledCity = BigDecimal.ZERO;
        kmRolledTravel = BigDecimal.ZERO;
        amountKmRolled = BigDecimal.ZERO;
        amountPriceCity = BigDecimal.ZERO;
        amountPriceTravel = BigDecimal.ZERO;
        
        LOG.info("Periodo utilizado nas consultas: {} a {}", initialDate, finalDate);
        
        loadCashRegisterCities(initialDate, finalDate);
        loadCashRegisterTravels(initialDate, finalDate);
        loadFuels(initialDate, finalDate);
        loadKmRolledCity();
        loadKmRolledTravel();
        loadAmountKmRolled();
        loadAmountWorkedDays();
        loadAmountPriceCity();
        loadAmountPriceTravel();
        
        LOG.info("Registros inicializados.");
    }
    
    private SummaryDTO loadSummary() {
        LOG.info("loadSummary...");
        
        BigDecimal netValue = BigDecimal.ZERO;
        BigDecimal grossValue = BigDecimal.ZERO;
        BigDecimal totalPrice = BigDecimal.ZERO;
        BigDecimal averageDayValue;

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

        for (Fuel fuel : fuels) {
        	netValue = netValue.subtract(fuel.getPrice());
		}
        
        averageDayValue = amountWorkedDays > 0
                ? totalPrice.divide(BigDecimal.valueOf(amountWorkedDays), MathContext.DECIMAL32)
                : BigDecimal.ZERO;

        return new SummaryDTO.SummaryBuilder()
                             .withNetValue(netValue)
                             .withGrossValue(grossValue)
                             .withAverageDayValue(averageDayValue)
                             .build();
    }
    
    private KmDTO loadKm() {
        LOG.info("loadKm...");
        return new KmDTO.KmBuilder()
                        .withAmountKmRolled(amountKmRolled)
                        .withKmRolledCity(kmRolledCity)
                        .withKmRolledTravel(kmRolledTravel)
                        .build();
    }
    
    private ConsumptionDTO loadConsumption() {
        LOG.info("loadConsumption...");

        BigDecimal amountLiters = BigDecimal.ZERO;
        BigDecimal litersPerKm = BigDecimal.ZERO;
        BigDecimal averagePriceSpentPerKm = BigDecimal.ZERO;
        BigDecimal amountPriceFuel = BigDecimal.ZERO;
        BigDecimal averageKmPerDay = BigDecimal.ZERO;
        BigDecimal averagePricePerDay = BigDecimal.ZERO;
        BigDecimal averagePriceFuel = BigDecimal.ZERO;

        for (Fuel fuel : fuels) {
            amountLiters = amountLiters.add(fuel.getLiters());
            amountPriceFuel = amountPriceFuel.add(fuel.getPrice());
        }

        if(amountKmRolled.compareTo(BigDecimal.ZERO) > 0) {
            litersPerKm = amountKmRolled.divide(amountLiters, MathContext.DECIMAL32);
            averagePriceSpentPerKm = amountPriceFuel.divide(amountKmRolled, MathContext.DECIMAL32);
        }
        
        if(amountWorkedDays > 0) {
            averageKmPerDay = amountKmRolled.divide(BigDecimal.valueOf(amountWorkedDays), MathContext.DECIMAL32);
            averagePricePerDay = (amountPriceCity.add(amountPriceTravel)).divide(BigDecimal.valueOf(amountWorkedDays),MathContext.DECIMAL32);
        }

        if(amountLiters.compareTo(BigDecimal.ZERO) > 0) {
            averagePriceFuel = amountPriceFuel.divide(amountLiters, MathContext.DECIMAL32);
        }
        
        return new ConsumptionDTO.ConsumptionBuilder()
                                 .withLitersPerKm(litersPerKm)
                                 .withAverageKmPerDay(averageKmPerDay)
                                 .withAveragePriceSpentPerKm(averagePriceSpentPerKm)
                                 .withAveragePricePerDay(averagePricePerDay)
                                 .withAveragePriceFuel(averagePriceFuel)
                                 .build();

    }
    
    private CardDTO loadCard() {
        LOG.info("loadCard...");
        CardCreditDTO cardCredit = loadCardCredit();
        CardDebitDTO cardDebit = loadCardDebit();
        CardSummaryDTO summary = loadCardSummary();
        
        return new CardDTO.CardBuilder()
                .withCredit(cardCredit)
                .withDebit(cardDebit)
                .withSummary(summary)
                .build();
        
    }
    
    private CardCreditDTO loadCardCredit() {
        LOG.info("loadCardCredit...");
        return new CardCreditDTO.CardCreditBuilder()
                .withGrossValue(BigDecimal.ZERO)
                .withNetValue(BigDecimal.ZERO)
                .withTaxValue(BigDecimal.ZERO)
                .build();
    }
    
    private CardDebitDTO loadCardDebit() {
        LOG.info("loadCardDebit...");
        return new CardDebitDTO.CardDebitBuilder()
                .withGrossValue(BigDecimal.ZERO)
                .withNetValue(BigDecimal.ZERO)
                .withTaxValue(BigDecimal.ZERO)
                .build();
    }
    
    private CardSummaryDTO loadCardSummary() {
        LOG.info("loadCardSummary...");
        return new CardSummaryDTO.CardSummaryBuilder()
                .withNetValue(BigDecimal.ZERO)
                .withPercent(BigDecimal.ZERO)
                .withTaxValue(BigDecimal.ZERO)
                .build();
    }
    
    private SpentDTO loadSpent() {
        LOG.info("loadSpent...");
        return new SpentDTO.SpentBuilder()
                .withAmount(BigDecimal.ZERO)
                .withFuel(BigDecimal.ZERO)
                .withOthers(BigDecimal.ZERO)
                .build();
    }
    
    private List<DriverDTO> loadDriver(){
        LOG.info("loadDriver...");
        List<Driver> drivers = driverRepository.findAll();
        List<DriverDTO> driversDTO = new ArrayList<>();
        
        drivers.stream()
               .forEach(driver -> {
                   
                   List<CashRegisterCity> registersCity = cashRegisterCities.stream()
                           .filter(city -> city.getDriver().equals(driver))
                           .collect(Collectors.toList());
                   
                   List<CashRegisterTravel> registersTravel = cashRegisterTravels.stream()
                           .filter(travel-> travel.getDriver().equals(driver))
                           .collect(Collectors.toList());
                   
                    BigDecimal amountCity;
                    BigDecimal amountTravel;
                    BigDecimal amount;
                    BigDecimal percentage = BigDecimal.ZERO;
                    BigDecimal average = BigDecimal.ZERO;

                    amountCity = registersCity.stream().map(CashRegisterCity::getPrice).reduce(BigDecimal.ZERO,
                            BigDecimal::add);
                    amountTravel = registersTravel.stream().map(CashRegisterTravel::getPrice).reduce(BigDecimal.ZERO,
                            BigDecimal::add);
                    amount = amountCity.add(amountTravel);

                    if (amountWorkedDays > 0) {
                        average = amount.divide(BigDecimal.valueOf(amountWorkedDays));
                    }

                    if (amountPriceCity.add(amountPriceTravel).compareTo(BigDecimal.ZERO) > 0) {
                        percentage = (amount.multiply(new BigDecimal(100)))
                                .divide(amountPriceCity.add(amountPriceTravel), MathContext.DECIMAL32);
                    }
                    
                    DriverDTO driverDTO = new DriverDTO.DriverBuilder()
                            .withAmount(amount)
                            .withAverage(average)
                            .withName(driver.getName())
                            .withPercentage(percentage)
                            .build();
                    
                    driversDTO.add(driverDTO);
               });
        
        return driversDTO;
    }
    
    private void loadCashRegisterCities(LocalDate initialDate, LocalDate finalDate) {
        LOG.info("loadCashRegisterCities...");
        cashRegisterCities = cashCityRepository.findByDateBetween(initialDate, finalDate);
    }
    
    private void loadCashRegisterTravels(LocalDate initialDate, LocalDate finalDate) {
        LOG.info("loadCashRegisterTravels...");
        cashRegisterTravels = cashTravelRepository.findByDateBetween(initialDate, finalDate);
    }
    
    private void loadFuels(LocalDate initialDate, LocalDate finalDate) {
        LOG.info("loadFuels...");
        fuels = fuelRepository.findByDateBetween(initialDate, finalDate);
    }
    
    private void loadKmRolledCity() {
        LOG.info("loadKmRolledCity...");
        kmRolledCity = cashRegisterCities.stream()
                        .map(CashRegisterCity::getKm)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    private void loadKmRolledTravel() {
        LOG.info("loadKmRolledTravel...");
        kmRolledTravel = cashRegisterTravels.stream()
                        .map(CashRegisterTravel::getKm)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    private void loadAmountKmRolled() {
        LOG.info("loadAmountKmRolled...");
        amountKmRolled = kmRolledCity.add(kmRolledTravel);
    }
    
    private void loadAmountWorkedDays() {
        LOG.info("loadAmountWorkedDays...");
        Set<LocalDate> setWorkedDays = new HashSet<>();
        
        cashRegisterCities.stream()
                          .forEach(city -> setWorkedDays.add(city.getDate()));
        cashRegisterTravels.stream()
                           .forEach(travel -> setWorkedDays.add(travel.getDate()));
        
        amountWorkedDays = setWorkedDays.size();
    }
    
    private void loadAmountPriceTravel() {
        LOG.info("loadAmountPriceTravel...");
        amountPriceTravel = cashRegisterTravels.stream()
                               .map(CashRegisterTravel::getPrice)
                               .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    private void loadAmountPriceCity() {
        LOG.info("loadAmountPriceCity...");
        amountPriceCity = cashRegisterCities.stream()
                            .map(CashRegisterCity::getPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    private String getDate() {
        return String.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/yyyy")));
    }

}

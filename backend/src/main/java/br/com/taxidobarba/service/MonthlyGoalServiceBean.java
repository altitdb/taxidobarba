package br.com.taxidobarba.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.business.results.monthlygoal.GoalDTO;
import br.com.taxidobarba.business.results.monthlygoal.MonthlyGoalDTO;
import br.com.taxidobarba.business.results.monthlygoal.SummaryDTO;
import br.com.taxidobarba.domain.CashRegisterCity;
import br.com.taxidobarba.domain.CashRegisterTravel;
import br.com.taxidobarba.repository.CashRegisterCityRepository;
import br.com.taxidobarba.repository.CashRegisterTravelRepository;

@Service
public class MonthlyGoalServiceBean implements MonthlyGoalService {

    private static final Logger LOG = LogManager.getLogger(MonthlyGoalServiceBean.class);

    private static final BigDecimal DAILY_GOAL = new BigDecimal("150");
    private static final BigDecimal MONTHLY_GOAL = new BigDecimal("4500");
    private static final LocalDate FIRST_DAY_OF_ACTUAL_MONTH = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    private static final LocalDate LAST_DAY_OF_ACTUAL_MONTH = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    private static final LocalDate FIRST_DAY_OF_LAST_MONTH = LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
    private static final LocalDate LAST_DAY_OF_LAST_MONTH = LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

    @Autowired
    private CashRegisterCityRepository cashCityRepository;
    @Autowired
    private CashRegisterTravelRepository cashTravelRepository;
    private List<CashRegisterCity> cashRegisterCities;
    private List<CashRegisterTravel> cashRegisterTravels;
    private Map<LocalDate, BigDecimal> amountActualMonthMap = new HashMap<>();
    private Map<LocalDate, BigDecimal> amountLastMonthMap = new HashMap<>();

    @Override
    public MonthlyGoalDTO generate() {
        LOG.info("generate...");
        
        initialize();
        List<GoalDTO> goal = loadGoal();
        SummaryDTO summary = loadSummary();
        
        return new MonthlyGoalDTO.MonthlyGoalBuilder()
                    .withGoal(goal)
                    .withSummary(summary)
                    .build();
    }

    private void initialize() {
        LOG.info("Inicializando registros...");

        loadCashRegisters(FIRST_DAY_OF_LAST_MONTH, LAST_DAY_OF_ACTUAL_MONTH);
        amountActualMonthMap = loadAmountPrice(FIRST_DAY_OF_ACTUAL_MONTH, LAST_DAY_OF_ACTUAL_MONTH);
        amountLastMonthMap = loadAmountPrice(FIRST_DAY_OF_LAST_MONTH, LAST_DAY_OF_LAST_MONTH);

        LOG.info("Registros inicializados.");
    }

    private void loadCashRegisters(LocalDate initialDate, LocalDate finalDate) {
        LOG.info("loadCashRegisters...");
        cashRegisterCities = cashCityRepository.findByDateBetween(initialDate, finalDate);
        cashRegisterTravels = cashTravelRepository.findByDateBetween(initialDate, finalDate);
    }

    private Map<LocalDate, BigDecimal> loadAmountPrice(LocalDate initialDate, LocalDate finalDate) {
        LOG.info("loadAmountPrice...");
        LOG.info(String.format("Periodo utilizado: [%s] a [%s]", initialDate, finalDate));
        
        Map<LocalDate, BigDecimal> amountPriceMap = new HashMap<>();
        LocalDate smallerDate = initialDate.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        
        long begin = System.currentTimeMillis();
        
        initialDate.datesUntil(finalDate.plusDays(1), Period.ofDays(1))
             .forEach(date -> {
                 LocalDate greaterDate = date.plusDays(1);
                 BigDecimal amountCity = cashRegisterCities.stream()
                                             .filter(city -> city.getDate().isAfter(smallerDate) && city.getDate().isBefore(greaterDate))
                                             .map(CashRegisterCity::getPrice)
                                             .reduce(BigDecimal.ZERO, BigDecimal::add);
                 
                 BigDecimal amountTravel = cashRegisterTravels.stream()
                                             .filter(travel -> travel.getDate().isAfter(smallerDate) && travel.getDate().isBefore(greaterDate))
                                             .map(CashRegisterTravel::getPrice)
                                             .reduce(BigDecimal.ZERO, BigDecimal::add);
                 
                 amountPriceMap.put(date, amountTravel.add(amountCity));
             });
        
        long end = System.currentTimeMillis();
        
        LOG.info(String.format("Tempo gasto em loadAmount: %s ms",(end - begin)));
        
        return amountPriceMap;
    }
    
    private List<GoalDTO> loadGoal(){
        LOG.info("loadGoal...");
        List<GoalDTO> goals = new ArrayList<>();
        
        FIRST_DAY_OF_ACTUAL_MONTH.datesUntil(LAST_DAY_OF_ACTUAL_MONTH.plusDays(1), Period.ofDays(1))
            .forEach(date -> {
                
                BigDecimal goal = DAILY_GOAL.multiply(BigDecimal.valueOf(date.getDayOfMonth()));
                BigDecimal lastMonth = amountLastMonthMap.get(date.minusMonths(1));
                BigDecimal actualMonth = amountActualMonthMap.get(date);
                BigDecimal percentage = (actualMonth.multiply(new BigDecimal(100))).divide(MONTHLY_GOAL, MathContext.DECIMAL32);
                
                GoalDTO dto = new GoalDTO.GoalBuilder()
                                         .withDate(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                                         .withActualMonth(actualMonth)
                                         .withGoal(goal)
                                         .withLastMonth(lastMonth)
                                         .withPercentage(percentage)
                                         .build();
                goals.add(dto);
            });
        
        return goals;
    }

    private SummaryDTO loadSummary() {
        LOG.info("loadSummary...");
        int amountDaysOfMonth = LAST_DAY_OF_ACTUAL_MONTH.getDayOfMonth();
        BigDecimal goal = DAILY_GOAL.multiply(BigDecimal.valueOf(amountDaysOfMonth));
        BigDecimal lastMonth = amountLastMonthMap.get(LAST_DAY_OF_LAST_MONTH);
        BigDecimal actualMonth = amountActualMonthMap.get(LAST_DAY_OF_ACTUAL_MONTH);
        BigDecimal percentage = (actualMonth.multiply(new BigDecimal(100))).divide(MONTHLY_GOAL, MathContext.DECIMAL32);
        
        return new SummaryDTO.SummaryBuilder()
                .withGoal(goal)
                .withActualMonth(actualMonth)
                .withLastMonth(lastMonth)
                .withPercentage(percentage)
                .build();
    }
}

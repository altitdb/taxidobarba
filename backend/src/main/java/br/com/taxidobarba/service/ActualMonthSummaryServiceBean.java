package br.com.taxidobarba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.business.results.actualmonth.ActualMonthSummaryDTO;
import br.com.taxidobarba.repository.CashRegisterCityRepository;
import br.com.taxidobarba.repository.CashRegisterTravelRepository;

@Service
public class ActualMonthSummaryServiceBean implements ActualMonthSummaryService {

    @Autowired
    private CashRegisterCityRepository cashCityRepository;
    @Autowired
    private CashRegisterTravelRepository cashTravelRepository;

    @Override
    public ActualMonthSummaryDTO generate() {
        // TODO Auto-generated method stub
        return null;
    }

}

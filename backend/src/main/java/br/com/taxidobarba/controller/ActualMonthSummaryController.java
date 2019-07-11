package br.com.taxidobarba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.business.results.actualmonth.ActualMonthSummaryDTO;
import br.com.taxidobarba.service.ActualMonthSummaryServiceBean;

@RestController
public class ActualMonthSummaryController {

    @Autowired
    private ActualMonthSummaryServiceBean service;

    @GetMapping("/api/v1/actual-month-summary")
    public ActualMonthSummaryDTO generate() {
        return service.generate();
    }

}

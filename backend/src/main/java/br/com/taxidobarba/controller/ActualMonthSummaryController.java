package br.com.taxidobarba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.business.results.actualmonth.ActualMonthSummaryDTO;
import br.com.taxidobarba.service.ActualMonthSummaryService;

@RestController
public class ActualMonthSummaryController {

    @Autowired
    private ActualMonthSummaryService service;

    @GetMapping(value = "/api/v1/actual-month-summary")
    public @ResponseBody ResponseEntity<ActualMonthSummaryDTO> generate() {
        return new ResponseEntity<>(service.generate(), HttpStatus.OK);
    }

}

package br.com.taxidobarba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.business.results.annualsummary.AnnualSummaryDTO;
import br.com.taxidobarba.service.AnnualSummaryServiceBean;

@RestController
public class AnnualSummaryController {

    @Autowired
    private AnnualSummaryServiceBean service;

    @GetMapping(value = "/api/v1/annual-summary")
    public @ResponseBody ResponseEntity<AnnualSummaryDTO> generate() {
        return new ResponseEntity<>(service.generate(), HttpStatus.OK);
    }

}

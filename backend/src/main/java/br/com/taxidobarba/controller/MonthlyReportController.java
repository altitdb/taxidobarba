package br.com.taxidobarba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.business.results.monthlyreport.MonthlyReportDTO;
import br.com.taxidobarba.service.MonthlyReportService;

@RestController
public class MonthlyReportController {

    @Autowired
    private MonthlyReportService service;

    @GetMapping(value = "/api/v1/monthly-report")
    public @ResponseBody ResponseEntity<MonthlyReportDTO> generate(
            @RequestParam(value = "month", required = false) Integer month,
            @RequestParam(value = "year", required = false) Integer year) {
        return new ResponseEntity<>(service.generate(month, year), HttpStatus.OK);
    }
}

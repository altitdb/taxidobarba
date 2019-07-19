package br.com.taxidobarba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.business.results.monthlyreport.MonthlyReportDTO;
import br.com.taxidobarba.service.MonthlyReportServiceBean;

@RestController
public class MonthlyReportController {

	@Autowired
	private MonthlyReportServiceBean service;

	@GetMapping("/api/v1/monthly-report")
	public MonthlyReportDTO generate(@RequestParam(value = "month", required = false) Integer month,
			@RequestParam(value = "year", required = false) Integer year) {
		return service.generate(month, year);
	}
}

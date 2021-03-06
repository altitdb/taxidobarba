package br.com.taxidobarba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.business.results.monthlygoal.MonthlyGoalDTO;
import br.com.taxidobarba.service.MonthlyGoalServiceBean;

@RestController
public class MonthlyGoalController {

	@Autowired
	private MonthlyGoalServiceBean service;

	@GetMapping("/api/v1/monthly-goal")
	public MonthlyGoalDTO generate() {
		return service.generate();
	}
}

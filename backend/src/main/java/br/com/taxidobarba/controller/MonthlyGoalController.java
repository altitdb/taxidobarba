package br.com.taxidobarba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.business.results.monthlygoal.MonthlyGoalDTO;
import br.com.taxidobarba.service.MonthlyGoalService;

@RestController
public class MonthlyGoalController {

    @Autowired
    private MonthlyGoalService service;
    
    @GetMapping(value = "/api/v1/monthly-goal")
    public @ResponseBody ResponseEntity<MonthlyGoalDTO> generate(){
        return new ResponseEntity<>(service.generate(), HttpStatus.OK);
    }
}

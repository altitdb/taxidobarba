package br.com.taxidobarba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.dto.CashRegisterCityRequestDTO;
import br.com.taxidobarba.service.CashRegisterCityService;

@RestController
public class CashRegisterCityController {

    @Autowired
    private CashRegisterCityService service;

    @PostMapping(value = "/api/v1/cash/city")
    public @ResponseBody ResponseEntity<HttpStatus> save(@RequestBody @Valid CashRegisterCityRequestDTO request) {
        service.save(request);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
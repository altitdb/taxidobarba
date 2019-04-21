package br.com.taxidobarba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.dto.CashRegisterTravelRequestDTO;
import br.com.taxidobarba.domain.dto.CashRegisterTravelResponseDTO;
import br.com.taxidobarba.service.CashRegisterTravelService;

@RestController
public class CashRegisterTravelController {

    @Autowired
    private CashRegisterTravelService service;

    @PostMapping(value = "/api/v1/cash/travel")
    public @ResponseBody ResponseEntity<CashRegisterTravelResponseDTO> save(
            @RequestBody @Valid CashRegisterTravelRequestDTO request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.ACCEPTED);
    }

}

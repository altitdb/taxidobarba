package br.com.taxidobarba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.request.dto.CashRegisterCityRequestDTO;
import br.com.taxidobarba.domain.response.dto.CashRegisterCityResponseDTO;
import br.com.taxidobarba.service.spec.CashRegisterCityService;

@RestController
public class CashRegisterCityController {

    @Autowired
    private CashRegisterCityService service;

    @PostMapping(value = "/api/v1/cash/city")
    public @ResponseBody ResponseEntity<CashRegisterCityResponseDTO> save(
            @RequestBody @Valid CashRegisterCityRequestDTO request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.ACCEPTED);
    }
    
    @PutMapping(value = "/api/v1/cash/city/{id}")
    public @ResponseBody ResponseEntity<CashRegisterCityResponseDTO> update(@PathVariable("id") String id,
            @RequestBody @Valid CashRegisterCityRequestDTO request) {
        return new ResponseEntity<>(service.update(id, request), HttpStatus.OK);
    }
    
    @GetMapping(value = "/api/v1/cash/city/{id}")
    public @ResponseBody ResponseEntity<CashRegisterCityResponseDTO> find(@PathVariable String id){
        return new ResponseEntity<>(service.find(id), HttpStatus.OK);
    }
}

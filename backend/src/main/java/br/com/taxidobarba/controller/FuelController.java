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

import br.com.taxidobarba.domain.request.dto.FuelRequestDTO;
import br.com.taxidobarba.domain.response.dto.FuelResponseDTO;
import br.com.taxidobarba.service.FuelServiceBean;

@RestController
public class FuelController {

    @Autowired
    private FuelServiceBean service;

    @PostMapping(value = "/api/v1/fuel")
    public @ResponseBody ResponseEntity<FuelResponseDTO> save(@RequestBody @Valid FuelRequestDTO request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.ACCEPTED);
    }
    
    @GetMapping(value = "/api/v1/fuel/{id}")
    public @ResponseBody ResponseEntity<FuelResponseDTO> find(@PathVariable String id){
        return new ResponseEntity<>(service.find(id), HttpStatus.OK);
    }
    
    @PutMapping("/api/v1/fuel/{id}")
    public FuelResponseDTO update(@PathVariable String id, @RequestBody @Valid FuelRequestDTO request) {
    	return service.update(id, request);
    }

}

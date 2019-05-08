package br.com.taxidobarba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.request.dto.FuelRequestDTO;
import br.com.taxidobarba.domain.response.dto.FuelResponseDTO;
import br.com.taxidobarba.service.spec.FuelService;

@RestController
public class FuelController {

    @Autowired
    private FuelService service;

    @PostMapping(value = "/api/v1/fuel")
    public @ResponseBody ResponseEntity<FuelResponseDTO> save(@RequestBody @Valid FuelRequestDTO request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.ACCEPTED);
    }

}

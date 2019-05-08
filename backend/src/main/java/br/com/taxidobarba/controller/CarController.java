package br.com.taxidobarba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.request.dto.CarRequestDTO;
import br.com.taxidobarba.domain.response.dto.CarResponseDTO;
import br.com.taxidobarba.service.spec.CarService;

@RestController
public class CarController {

    @Autowired
    private CarService service;

    @PostMapping(value = "/api/v1/car")
    public @ResponseBody ResponseEntity<HttpStatus> save(@RequestBody @Valid CarRequestDTO request) {
        service.save(request);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/api/v1/car")
    public @ResponseBody ResponseEntity<List<CarResponseDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

}

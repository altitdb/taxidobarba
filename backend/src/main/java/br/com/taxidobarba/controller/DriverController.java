package br.com.taxidobarba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.dto.DriverRequestDTO;
import br.com.taxidobarba.domain.dto.DriverResponseDTO;
import br.com.taxidobarba.service.DriverService;

@RestController
public class DriverController {

    @Autowired
    private DriverService service;

    @PostMapping(value = "/api/v1/driver")
    public @ResponseBody ResponseEntity<HttpStatus> save(@RequestBody @Valid DriverRequestDTO request) {
        service.save(request);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/api/v1/driver")
    public @ResponseBody ResponseEntity<List<DriverResponseDTO>> findAll() {
        List<DriverResponseDTO> drivers = service.findAll();
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/driver/{id}")
    public @ResponseBody ResponseEntity<DriverResponseDTO> findById(@PathVariable("id") String id) {
        DriverResponseDTO driverResponseDTO = service.findById(id);
        return new ResponseEntity<>(driverResponseDTO, HttpStatus.OK);
    }
}

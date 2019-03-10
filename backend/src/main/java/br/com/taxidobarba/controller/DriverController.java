package br.com.taxidobarba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping(value = "/api/v1/driver/save")
	public @ResponseBody ResponseEntity<DriverResponseDTO> save(@RequestBody @Valid DriverRequestDTO request){
		DriverResponseDTO driverResponseDTO = service.save(request);
		return new ResponseEntity<>(driverResponseDTO,HttpStatus.ACCEPTED);
	}
	
}

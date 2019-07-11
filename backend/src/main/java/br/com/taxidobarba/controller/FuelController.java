package br.com.taxidobarba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.request.dto.FuelRequestDTO;
import br.com.taxidobarba.domain.response.dto.FuelResponseDTO;
import br.com.taxidobarba.service.FuelServiceBean;

@RestController
public class FuelController {

	@Autowired
	private FuelServiceBean service;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/api/v1/fuel")
	public FuelResponseDTO save(@RequestBody @Valid FuelRequestDTO request) {
		return service.save(request);
	}

	@GetMapping("/api/v1/fuel/{id}")
	public FuelResponseDTO find(@PathVariable String id) {
		return service.find(id);
	}

	@PutMapping("/api/v1/fuel/{id}")
	public FuelResponseDTO update(@PathVariable String id, @RequestBody @Valid FuelRequestDTO request) {
		return service.update(id, request);
	}

}

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

import br.com.taxidobarba.domain.request.dto.CashRegisterCityRequestDTO;
import br.com.taxidobarba.domain.response.dto.CashRegisterCityResponseDTO;
import br.com.taxidobarba.service.CashRegisterCityServiceBean;

@RestController
public class CashRegisterCityController {

	@Autowired
	private CashRegisterCityServiceBean service;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/api/v1/cash/city")
	public CashRegisterCityResponseDTO save(@RequestBody @Valid CashRegisterCityRequestDTO request) {
		return service.save(request);
	}

	@PutMapping("/api/v1/cash/city/{id}")
	public CashRegisterCityResponseDTO update(@PathVariable("id") String id,
			@RequestBody @Valid CashRegisterCityRequestDTO request) {
		return service.update(id, request);
	}

	@GetMapping("/api/v1/cash/city/{id}")
	public CashRegisterCityResponseDTO find(@PathVariable String id) {
		return service.find(id);
	}
}

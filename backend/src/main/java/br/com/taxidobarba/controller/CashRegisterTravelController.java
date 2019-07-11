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

import br.com.taxidobarba.domain.request.dto.CashRegisterTravelRequestDTO;
import br.com.taxidobarba.domain.response.dto.CashRegisterTravelResponseDTO;
import br.com.taxidobarba.service.CashRegisterTravelServiceBean;

@RestController
public class CashRegisterTravelController {

	@Autowired
	private CashRegisterTravelServiceBean service;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/api/v1/cash/travel")
	public CashRegisterTravelResponseDTO save(@RequestBody @Valid CashRegisterTravelRequestDTO request) {
		return service.save(request);
	}

	@PutMapping("/api/v1/cash/travel/{id}")
	public CashRegisterTravelResponseDTO update(@PathVariable("id") String id,
			@RequestBody @Valid CashRegisterTravelRequestDTO request) {
		return service.update(id, request);
	}

	@GetMapping("/api/v1/cash/travel/{id}")
	public CashRegisterTravelResponseDTO find(@PathVariable String id) {
		return service.find(id);
	}

}

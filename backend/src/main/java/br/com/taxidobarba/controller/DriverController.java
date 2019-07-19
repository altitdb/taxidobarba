package br.com.taxidobarba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.request.dto.DriverRequestDTO;
import br.com.taxidobarba.domain.response.dto.DriverResponseDTO;
import br.com.taxidobarba.service.DriverServiceBean;

@RestController
public class DriverController {

	@Autowired
	private DriverServiceBean service;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/api/v1/driver")
	public void save(@RequestBody @Valid DriverRequestDTO request) {
		service.save(request);
	}

	@GetMapping("/api/v1/driver")
	public List<DriverResponseDTO> findAll() {
		return service.findAll();
	}

	@GetMapping("/api/v1/driver/{id}")
	public DriverResponseDTO findById(@PathVariable("id") String id) {
		return service.findById(id);
	}
}

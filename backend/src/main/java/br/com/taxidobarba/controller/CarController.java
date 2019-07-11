package br.com.taxidobarba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.request.dto.CarRequestDTO;
import br.com.taxidobarba.domain.response.dto.CarResponseDTO;
import br.com.taxidobarba.service.CarServiceBean;

@RestController
public class CarController {

	@Autowired
	private CarServiceBean service;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/api/v1/car")
	public void save(@RequestBody @Valid CarRequestDTO request) {
		service.save(request);
	}

	@GetMapping("/api/v1/car")
	public List<CarResponseDTO> findAll() {
		return service.findAll();
	}

}

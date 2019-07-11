package br.com.taxidobarba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.enumerated.TrafficTicketStatus;
import br.com.taxidobarba.domain.request.dto.TrafficTicketRequestDTO;
import br.com.taxidobarba.domain.response.dto.TrafficTicketResponseDTO;
import br.com.taxidobarba.service.TrafficTicketServiceBean;

@RestController
public class TrafficTicketController {

	@Autowired
	private TrafficTicketServiceBean service;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/api/v1/traffic-ticket")
	public void save(@RequestBody @Valid TrafficTicketRequestDTO request) {
		service.save(request);
	}

	@GetMapping("/api/v1/traffic-ticket")
	public List<TrafficTicketResponseDTO> findAll(
			@RequestParam(value = "status", required = false) TrafficTicketStatus status) {
		return service.findAll(status);
	}

}

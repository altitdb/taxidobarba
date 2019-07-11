package br.com.taxidobarba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.request.dto.PaymentTrafficTicketRequestDTO;
import br.com.taxidobarba.service.PaymentTrafficTicketServiceBean;

@RestController
public class PaymentTrafficTicketController {

	@Autowired
	private PaymentTrafficTicketServiceBean service;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/api/v1/traffic-ticket/payment")
	public void save(@RequestBody @Valid PaymentTrafficTicketRequestDTO request) {
		service.save(request);
	}

}

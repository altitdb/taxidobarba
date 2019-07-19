package br.com.taxidobarba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.taxidobarba.service.CreditCardPaymentServiceBean;

@RestController
public class CreditCardPaymentController {

	@Autowired
	private CreditCardPaymentServiceBean service;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/api/v1/credit-card")
	public void save(@RequestParam MultipartFile file) {
		service.save(file);
	}

}

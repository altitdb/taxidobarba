package br.com.taxidobarba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.request.dto.PaymentTrafficTicketRequestDTO;
import br.com.taxidobarba.service.PaymentTrafficTicketService;

@RestController
public class PaymentTrafficTicketController {

    @Autowired
    private PaymentTrafficTicketService service;
    
    @PostMapping(value = "/api/v1/traffic-ticket/payment")
    public @ResponseBody ResponseEntity<HttpStatus> save(@RequestBody @Valid PaymentTrafficTicketRequestDTO request){
        service.save(request);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
}

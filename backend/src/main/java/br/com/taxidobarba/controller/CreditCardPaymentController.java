package br.com.taxidobarba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.taxidobarba.service.spec.CreditCardPaymentService;

@RestController
public class CreditCardPaymentController {
    
    @Autowired
    private CreditCardPaymentService service;
    
    @PostMapping(value = "/api/v1/credit-card")
    public @ResponseBody ResponseEntity<HttpStatus> save(@RequestParam MultipartFile file){
        service.save(file);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}

package br.com.taxidobarba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.request.dto.LoginRequestDTO;
import br.com.taxidobarba.service.LoginServiceBean;

@RestController
public class LoginController {

    @Autowired
    private LoginServiceBean service;

    @PostMapping(value = "/api/v1/login")
    public @ResponseBody ResponseEntity<HttpStatus> login(@RequestBody @Valid LoginRequestDTO request) {
        service.login(request);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}

package br.com.taxidobarba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxidobarba.domain.enumerated.TrafficTicketStatus;
import br.com.taxidobarba.domain.request.dto.TrafficTicketRequestDTO;
import br.com.taxidobarba.domain.response.dto.TrafficTicketResponseDTO;
import br.com.taxidobarba.service.TrafficTicketServiceBean;

@RestController
public class TrafficTicketController {

    @Autowired
    private TrafficTicketServiceBean service;

    @PostMapping(value = "/api/v1/traffic-ticket")
    public @ResponseBody ResponseEntity<HttpStatus> save(@RequestBody @Valid TrafficTicketRequestDTO request) {
        service.save(request);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/api/v1/traffic-ticket")
    public @ResponseBody ResponseEntity<List<TrafficTicketResponseDTO>> findAll(
            @RequestParam(value = "status", required = false) TrafficTicketStatus status) {
        return new ResponseEntity<>(service.findAll(status), HttpStatus.OK);
    }

}

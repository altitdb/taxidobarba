package br.com.taxidobarba.service;

import br.com.taxidobarba.domain.dto.TrafficTicketRequestDTO;

public interface TrafficTicketService {

    public void save(TrafficTicketRequestDTO request);
    
}

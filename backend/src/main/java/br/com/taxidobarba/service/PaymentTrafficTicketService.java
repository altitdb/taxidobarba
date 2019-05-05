package br.com.taxidobarba.service;

import br.com.taxidobarba.domain.request.dto.PaymentTrafficTicketRequestDTO;

public interface PaymentTrafficTicketService {

    public void save(PaymentTrafficTicketRequestDTO request);
    
}

package br.com.taxidobarba.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.taxidobarba.domain.PaymentTrafficTicket;
import br.com.taxidobarba.domain.TrafficTicket;

@Repository
public interface PaymentTrafficTicketRepository extends MongoRepository<PaymentTrafficTicket, String>{

    public List<PaymentTrafficTicket> findByTrafficTicket(TrafficTicket trafficTicket);
    
}

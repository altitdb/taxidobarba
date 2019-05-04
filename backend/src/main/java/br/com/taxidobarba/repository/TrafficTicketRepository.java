package br.com.taxidobarba.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.taxidobarba.domain.TrafficTicket;

@Repository
public interface TrafficTicketRepository extends MongoRepository<TrafficTicket, String> {

}

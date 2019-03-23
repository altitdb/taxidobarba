package br.com.taxidobarba.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.taxidobarba.domain.CashRegisterTravel;

@Repository
public interface CashRegisterTravelRepository extends MongoRepository<CashRegisterTravel, String> {

}

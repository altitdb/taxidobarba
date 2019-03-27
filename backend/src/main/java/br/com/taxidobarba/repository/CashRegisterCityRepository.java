package br.com.taxidobarba.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.taxidobarba.domain.CashRegisterCity;

@Repository
public interface CashRegisterCityRepository extends MongoRepository<CashRegisterCity, String>{

}

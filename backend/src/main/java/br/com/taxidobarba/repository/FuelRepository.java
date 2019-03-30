package br.com.taxidobarba.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.taxidobarba.domain.Fuel;

@Repository
public interface FuelRepository extends MongoRepository<Fuel, String>{

}

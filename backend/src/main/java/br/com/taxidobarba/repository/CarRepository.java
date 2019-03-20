package br.com.taxidobarba.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.taxidobarba.domain.Car;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    public Optional<Car> findById(String id);

    public Optional<Car> findByLicensePlate(String licensePlate);

}

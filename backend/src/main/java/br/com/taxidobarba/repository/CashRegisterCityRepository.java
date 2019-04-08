package br.com.taxidobarba.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.taxidobarba.domain.CashRegisterCity;

@Repository
public interface CashRegisterCityRepository extends MongoRepository<CashRegisterCity, String> {

    @Query(value = "{ 'date' : {$gte : ?0, $lte: ?1 }}")
    public List<CashRegisterCity> findByDateBetween(LocalDate initialDate, LocalDate finalDate);

}

package br.com.taxidobarba.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.taxidobarba.domain.CashRegisterTravel;

@Repository
public interface CashRegisterTravelRepository extends MongoRepository<CashRegisterTravel, String> {

    public List<CashRegisterTravel> findByDateBetween(LocalDate initialDate, LocalDate finalDate);

}

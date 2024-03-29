package br.com.taxidobarba.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.taxidobarba.domain.CashRegisterTravel;

@Repository
public interface CashRegisterTravelRepository extends MongoRepository<CashRegisterTravel, String> {

    @Query(value = "{ 'date' : {$gte : ?0, $lte: ?1 }}")
    public List<CashRegisterTravel> findByDateBetween(LocalDate initialDate, LocalDate finalDate);
    
    public List<CashRegisterTravel> findByIdIn(List<String> ids);

}

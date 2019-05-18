package br.com.taxidobarba.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.taxidobarba.domain.CreditCardPayment;

@Repository
public interface CreditCardPaymentRepository extends MongoRepository<CreditCardPayment, String> {

    public List<CreditCardPayment> findByTransactionIdIn(List<String> ids);

}

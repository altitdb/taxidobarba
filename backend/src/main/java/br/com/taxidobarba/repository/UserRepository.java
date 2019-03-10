package br.com.taxidobarba.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.taxidobarba.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	public Optional<User> findByUsername(String username);
}

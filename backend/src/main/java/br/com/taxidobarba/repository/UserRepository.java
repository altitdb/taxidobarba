package br.com.taxidobarba.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.taxidobarba.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

	public Optional<User> findByUsername(String username);
}

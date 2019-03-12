package br.com.taxidobarba.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.taxidobarba.domain.Driver;

@Repository
public interface DriverRepository extends MongoRepository<Driver, String> {

	public Optional<Driver> findById(String id);

	public Optional<Driver> findByTaxIdentifier(String taxIdentifier);

	public Optional<Driver> findByLicenseNumber(String licenseNumber);

	public Optional<Driver> findByNationalRegister(String licenseNumber);
}

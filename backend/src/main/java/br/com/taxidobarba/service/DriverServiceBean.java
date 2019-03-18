package br.com.taxidobarba.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.dto.DriverRequestDTO;
import br.com.taxidobarba.domain.dto.DriverResponseDTO;
import br.com.taxidobarba.exception.BusinessExpetion;
import br.com.taxidobarba.repository.DriverRepository;

@Service
public class DriverServiceBean implements DriverService{

	private static final Logger LOG = LogManager.getLogger(DriverServiceBean.class);
	
	@Autowired
	private DriverRepository repository;
	
	@Override
	public void save(DriverRequestDTO request) {
		validateDriverRequest(request);
		Driver driver = driverRequestDTOToDriver(request);
		
		LOG.info("Persistindo motorista: " + driver);
		repository.save(driver);
		LOG.info("Motorista persistido.");
		
	}

	@Override
	public List<DriverResponseDTO> findAll() {
		LOG.info("Buscando todos motoristas...");
		List<Driver> drivers = repository.findAll();
		LOG.info("Quantidade de motoristas encontrados: " + drivers.size());
		return driversToListDriverResponseDTO(drivers);
	}

	@Override
	public DriverResponseDTO findById(String id) {
		return null;
	}

	@Override
	public ResponseEntity<HttpStatus> delete(String id) {
		return null;
	}
	
	private void validateDriverRequest(DriverRequestDTO request) {
		LOG.info("Iniciando validacao antes de salvar...");
		validateTaxIdentifier(request.getTaxIdentifier());
		validateNationalRegister(request.getNationalRegister());
		validateLicenseNumber(request.getLicenseNumber());
		LOG.info("Request validado com sucesso.");
	}
	
	private void validateTaxIdentifier(String taxIdentifier) {
		Optional<Driver> driver = repository.findByTaxIdentifier(taxIdentifier);
		if(driver.isPresent()) {
			LOG.warn(String.format("Motorista ja cadastrado com CPF [%s]", taxIdentifier));
			throw new BusinessExpetion("Motorista ja cadastrado com esse CPF. " + driver);
		}
		LOG.info("CPF validado!");
	}
	
	private void validateNationalRegister(String nationalRegister) {
		Optional<Driver> driver = repository.findByNationalRegister(nationalRegister);
		if(driver.isPresent()) {
			LOG.warn(String.format("Motorista ja cadastrado com registro nacional [%s]", nationalRegister));
			throw new BusinessExpetion("Motorista ja cadastrado com esse registro nacional. " + driver);
		}
		LOG.info("Registro nacional validado!");
	}
	
	private void validateLicenseNumber(String licenseNumber) {
		Optional<Driver> driver = repository.findByLicenseNumber(licenseNumber);
		if(driver.isPresent()) {
			LOG.warn(String.format("Motorista ja cadastrado com licenca [%s]", licenseNumber));
			throw new BusinessExpetion("Motorista ja cadastrado com essa licenca. " + driver);
		}
		LOG.info("Licenca validada!");
	}
	
	private Driver driverRequestDTOToDriver(DriverRequestDTO request) {
		return new Driver.DriverBuilder()
									.withName(request.getName())
									.withBirthDate(request.getBirthDate())
									.withLicenseDueDate(request.getLicenseDueDate())
									.withLicenseNumber(request.getLicenseNumber())
									.withNationalRegister(request.getNationalRegister())
									.withPriceKm(request.getPriceKm())
									.withTaxIdentifier(request.getTaxIdentifier())
									.isEnable(request.isEnable())
									.build();
	}
	
	private List<DriverResponseDTO> driversToListDriverResponseDTO(List<Driver> drivers) {
		return drivers.stream()
					  .map(driver -> new DriverResponseDTO.DriverResponseBuilder()
						 .withBirthDate(driver.getBirthDate())
						 .withId(driver.getId())
						 .withLicenseDueDate(driver.getLicenseDueDate())
						 .isEnable(driver.isEnable())
						 .withLicenseNumber(driver.getLicenseNumber())
						 .withName(driver.getName())
						 .withNationalRegister(driver.getNationalRegister())
						 .withPriceKm(driver.getPriceKm())
						 .withTaxIdentifier(driver.getTaxIdentifier())
						 .build())
					  .collect(Collectors.toList());
	}

}

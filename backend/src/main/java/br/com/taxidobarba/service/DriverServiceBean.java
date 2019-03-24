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
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.DriverRepository;

@Service
public class DriverServiceBean implements DriverService {

    private static final Logger LOG = LogManager.getLogger(DriverServiceBean.class);

    @Autowired
    private DriverRepository repository;

    @Override
    public void save(DriverRequestDTO request) {
        validateDriverRequest(request);
        Driver driver = driverRequestDTOToEntity(request);
        LOG.info("Persistindo motorista: " + driver);
        repository.save(driver);
        LOG.info("Motorista persistido.");

    }

    @Override
    public List<DriverResponseDTO> findAll() {
        LOG.info("Buscando todos motoristas...");
        return driversToListDriverResponseDTO(repository.findAll());
    }

    @Override
    public DriverResponseDTO findById(String id) {
        LOG.info("Buscando motorista pelo id: " + id);
        Optional<Driver> driver = repository.findById(id);
        return driverToDriverResponseDTO(driver.orElseThrow(() -> new BusinessException("Motorista não localizado.")));
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
        repository.findByTaxIdentifier(taxIdentifier).ifPresent(driver -> {
            throw new BusinessException("Motorista ja cadastrado com esse CPF.");
        });
        LOG.info("CPF validado!");
    }

    private void validateNationalRegister(String nationalRegister) {
        repository.findByNationalRegister(nationalRegister).ifPresent(driver -> {
            throw new BusinessException("Motorista ja cadastrado com esse registro nacional.");
        });
        LOG.info("Registro nacional validado!");
    }

    private void validateLicenseNumber(String licenseNumber) {
        repository.findByLicenseNumber(licenseNumber).ifPresent(driver -> {
            throw new BusinessException("Motorista ja cadastrado com essa licenca.");
        });
        LOG.info("Licenca validada!");
    }

    private Driver driverRequestDTOToEntity(DriverRequestDTO request) {
        return new Driver.DriverBuilder()
                         .withName(request.getName())
                         .withBirthDate(request.getBirthDate())
                         .withLicenseDueDate(request.getLicenseDueDate())
                         .withLicenseNumber(request.getLicenseNumber())
                         .withNationalRegister(request.getNationalRegister())
                         .withPriceKm(request.getPriceKm())
                         .withPercentualTravel(request.getPercentualTravel())
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
                            .withPercentualTravel(driver.getPercentualTravel())
                            .withTaxIdentifier(driver.getTaxIdentifier())
                            .build())
                .collect(Collectors.toList());
    }
    
    private DriverResponseDTO driverToDriverResponseDTO(Driver driver) {
        return new DriverResponseDTO.DriverResponseBuilder()
                            .withBirthDate(driver.getBirthDate())
                            .withId(driver.getId())
                            .withLicenseDueDate(driver.getLicenseDueDate())
                            .isEnable(driver.isEnable())
                            .withLicenseNumber(driver.getLicenseNumber())
                            .withName(driver.getName())
                            .withNationalRegister(driver.getNationalRegister())
                            .withPriceKm(driver.getPriceKm())
                            .withTaxIdentifier(driver.getTaxIdentifier())
                            .build();
    }

}

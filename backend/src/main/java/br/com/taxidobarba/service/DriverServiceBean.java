package br.com.taxidobarba.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.request.dto.DriverRequestDTO;
import br.com.taxidobarba.domain.response.dto.DriverResponseDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.validator.RequestValidator;

@Service
public class DriverServiceBean {

    private static final Logger LOG = LogManager.getLogger(DriverServiceBean.class);

    @Autowired
    private DriverRepository repository;
    @Autowired
    private RequestValidator<DriverRequestDTO> validator;

    public void save(DriverRequestDTO request) {
        
        validator.validateOnSave(request);
        
        Driver driver = driverRequestDTOToEntity(request);
        
        LOG.debug("Persistindo motorista...");
        repository.save(driver);
        LOG.debug("Motorista persistido.");

    }

    public List<DriverResponseDTO> findAll() {
        LOG.debug("Buscando todos motoristas...");
        return driversToListDriverResponseDTO(repository.findAll());
    }

    public DriverResponseDTO findById(String id) {
        LOG.info("Buscando motorista pelo id: {}", id);
        Optional<Driver> driver = repository.findById(id);
        return driverToDriverResponseDTO(driver.orElseThrow(() -> new BusinessException("Motorista não localizado.")));
    }

    private Driver driverRequestDTOToEntity(DriverRequestDTO request) {
        return new Driver.DriverBuilder()
                         .withName(request.getName())
                         .withFullName(request.getFullName())
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

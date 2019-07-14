package br.com.taxidobarba.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.taxidobarba.domain.request.dto.DriverRequestDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.DriverRepository;

@Component
public class DriverValidator implements RequestValidator<DriverRequestDTO> {

    private static final Logger LOG = LogManager.getLogger(DriverValidator.class);

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public void validateOnSave(DriverRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        validateTaxIdentifier(request.getTaxIdentifier());
        validateNationalRegister(request.getNationalRegister());
        validateLicenseNumber(request.getLicenseNumber());

    }

    private void validateTaxIdentifier(String taxIdentifier) {
        driverRepository.findByTaxIdentifier(taxIdentifier).ifPresent(driver -> {
            throw new BusinessException("Motorista ja cadastrado com esse CPF.");
        });
    }

    private void validateNationalRegister(String nationalRegister) {
        driverRepository.findByNationalRegister(nationalRegister).ifPresent(driver -> {
            throw new BusinessException("Motorista ja cadastrado com esse registro nacional.");
        });
    }

    private void validateLicenseNumber(String licenseNumber) {
        driverRepository.findByLicenseNumber(licenseNumber).ifPresent(driver -> {
            throw new BusinessException("Motorista ja cadastrado com essa licenca.");
        });
    }

}

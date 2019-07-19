package br.com.taxidobarba.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.taxidobarba.domain.request.dto.CarRequestDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.CarRepository;

@Component
public class CarValidator implements RequestValidator<CarRequestDTO> {

    private static final Logger LOG = LogManager.getLogger(CarValidator.class);
    
    @Autowired
    private CarRepository carRepository;
    
    @Override
    public void validateOnSave(CarRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        
        validateLicensePlate(request.getLicensePlate());
    }
    
    private void validateLicensePlate(String licensePlate) {
        carRepository.findByLicensePlate(licensePlate).ifPresent(c -> {
            throw new BusinessException("Placa já cadastrada.");
        });
    }

}

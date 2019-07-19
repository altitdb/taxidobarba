package br.com.taxidobarba.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.request.dto.CarRequestDTO;
import br.com.taxidobarba.domain.response.dto.CarResponseDTO;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.validator.RequestValidator;

@Service
public class CarServiceBean {

    private static final Logger LOG = LogManager.getLogger(CarServiceBean.class);

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private RequestValidator<CarRequestDTO> validator;

    public void save(CarRequestDTO request) {
        
        validator.validateOnSave(request);
        
        LOG.debug("Persistindo carro...");
        carRepository.save(carRequestDtoToEntity(request));
        LOG.debug("Carro persistido.");
    }

    public List<CarResponseDTO> findAll() {
        LOG.debug("Buscando todos carros...");
        return carsToListCarResponseDTO(carRepository.findAll());
        
    }

    private Car carRequestDtoToEntity(CarRequestDTO request) {
        return new Car.CarBuilder()
                    .withName(request.getName())
                    .withLicensePlate(request.getLicensePlate())
                    .build();
    }
    
    private List<CarResponseDTO> carsToListCarResponseDTO(List<Car> cars) {
        return cars.stream()
                   .map(car -> new CarResponseDTO.CarResponseBuilder()
                               .withId(car.getId())
                               .withName(car.getName())
                               .withLicensePlate(car.getLicensePlate())
                               .build())
                   .collect(Collectors.toList());
    }
}

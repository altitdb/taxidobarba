package br.com.taxidobarba.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.request.dto.CarRequestDTO;
import br.com.taxidobarba.domain.response.dto.CarResponseDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.service.spec.CarService;

@Service
public class CarServiceBean implements CarService {

    private static final Logger LOG = LogManager.getLogger(CarServiceBean.class);

    @Autowired
    private CarRepository repository;

    @Override
    public void save(CarRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        validateLicensePlate(request.getLicensePlate());
        LOG.info("Persistindo carro...");
        repository.save(carRequestDtoToEntity(request));
        LOG.info("Carro persistido.");
    }

    @Override
    public List<CarResponseDTO> findAll() {
        LOG.info("Buscando todos carros...");
        return carsToListCarResponseDTO(repository.findAll());
        
    }

    private void validateLicensePlate(String licensePlate) {
        LOG.info("Validando placa...");
        repository.findByLicensePlate(licensePlate).ifPresent(c -> {
            throw new BusinessException("Placa já cadastrada.");
        });
        LOG.info("Placa validada!");
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

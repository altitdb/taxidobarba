package br.com.taxidobarba.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.dto.CarRequestDTO;
import br.com.taxidobarba.domain.dto.CarResponseDTO;
import br.com.taxidobarba.exception.BusinessExpetion;
import br.com.taxidobarba.repository.CarRepository;

@Service
public class CarServiceBean implements CarService {

    private static final Logger LOG = LogManager.getLogger(CarServiceBean.class);

    @Autowired
    private CarRepository repository;

    @Override
    public void save(CarRequestDTO request) {
        LOG.info("Dados recebidos no request: " + request);
        
        validateLicensePlate(request.getLicensePlate());
        
        Car car = carRequestDtoToCar(request);
        LOG.info("Persistindo carro...");
        repository.save(car);
        LOG.info("Carro persistido.");
    }

    @Override
    public List<CarResponseDTO> findAll() {
        LOG.info("Buscando todos carros...");
        List<Car> cars = repository.findAll();
        LOG.info("Quantidade de carros retornados: " + cars.size());
        return carRequestDtoToListCarResponseDTO(cars);
        
    }

    private void validateLicensePlate(String licensePlate) {
        LOG.info("Validando placa...");
        Optional<Car> car = repository.findByLicensePlate(licensePlate);
        if (car.isPresent()) {
            LOG.warn(String.format("Carro ja cadastrado com essa placa [%s]", licensePlate));
            throw new BusinessExpetion("Placa já cadastrada.");
        }
        LOG.info("Placa validada!");
    }
    
    private Car carRequestDtoToCar(CarRequestDTO request) {
        return new Car.CarBuilder()
                    .withName(request.getName())
                    .withLicensePlate(request.getLicensePlate())
                    .build();
    }
    
    private List<CarResponseDTO> carRequestDtoToListCarResponseDTO(List<Car> cars) {
        return cars.stream()
                   .map(car -> new CarResponseDTO.CarResponseBuilder()
                               .withId(car.getId())
                               .withName(car.getName())
                               .withLicensePlate(car.getLicensePlate())
                               .build())
                   .collect(Collectors.toList());
    }

}
package br.com.taxidobarba.service.impl;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.Fuel;
import br.com.taxidobarba.domain.request.dto.FuelRequestDTO;
import br.com.taxidobarba.domain.response.dto.FuelResponseDTO;
import br.com.taxidobarba.domain.response.dto.SimpleCarResponseDTO;
import br.com.taxidobarba.domain.response.dto.SimpleDriverResponseDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.repository.FuelRepository;
import br.com.taxidobarba.service.spec.FuelService;

@Service
public class FuelServiceBean implements FuelService{

    private static final Logger LOG = LogManager.getLogger(FuelServiceBean.class);
    
    @Autowired
    private FuelRepository repository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;
    
    @Override
    public FuelResponseDTO save(FuelRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        
        LOG.info("Persistindo dados...");
        Fuel fuel = requestDtoToEntity(request);
        repository.save(fuel);
        LOG.info("Dados persistidos.");
        
        return entityToResponseDto(fuel);
        
    }
    
    private Fuel requestDtoToEntity(FuelRequestDTO request) {
        Car car = findCarById(request.getCar());
        Driver driver = findDriverById(request.getDriver());
        
        BigDecimal price = request.getPrice();
        BigDecimal liters = request.getLiters();
        BigDecimal fuelPrice = price.divide(liters, MathContext.DECIMAL32);
        
        return new Fuel.FuelBuilder()
                .wihtCar(car)
                .withDate(request.getDate())
                .withDriver(driver)
                .withFuelPrice(fuelPrice)
                .withKm(request.getKm())
                .withLiters(liters)
                .withPrice(price)
                .build();
    }
    
    private FuelResponseDTO entityToResponseDto(Fuel fuel) {
        SimpleCarResponseDTO carDto = new SimpleCarResponseDTO(fuel.getCar());
        SimpleDriverResponseDTO driverDto = new SimpleDriverResponseDTO(fuel.getDriver());
        
        return new FuelResponseDTO.FuelResponseBuilder()
                .wihtCar(carDto)
                .withDate(fuel.getDate())
                .withDriver(driverDto)
                .withFuelPrice(fuel.getFuelPrice())
                .withKm(fuel.getKm())
                .withLiters(fuel.getLiters())
                .withPrice(fuel.getPrice())
                .build();
    }
    
    private Car findCarById(String id) {
        LOG.info("Buscando carro...");
        return carRepository.findById(id).orElseThrow(() -> new BusinessException("Carro nao localizado."));
    }

    private Driver findDriverById(String id) {
        LOG.info("Buscando motorista...");
        return driverRepository.findById(id).orElseThrow(() -> new BusinessException("Motorista nao localizado."));
    }

}

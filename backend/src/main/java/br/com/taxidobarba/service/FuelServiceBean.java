package br.com.taxidobarba.service;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.Fuel;
import br.com.taxidobarba.domain.dto.FuelRequestDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.repository.FuelRepository;

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
    public void save(FuelRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        LOG.info("Persistindo dados...");
        Fuel fuel = fuelRequestDtoToEntity(request);
        repository.save(fuel);
        LOG.info("Dados persistidos.");
    }
    
    private Fuel fuelRequestDtoToEntity(FuelRequestDTO request) {
        Car car = findCarById(request.getCarId());
        Driver driver = findDriverById(request.getDriverId());
        
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
    
    private Car findCarById(String id) {
        LOG.info("Buscando carro...");
        return carRepository.findById(id).orElseThrow(() -> new BusinessException("Carro nao localizado."));
    }

    private Driver findDriverById(String id) {
        LOG.info("Buscando motorista...");
        return driverRepository.findById(id).orElseThrow(() -> new BusinessException("Motorista nao localizado."));
    }

}

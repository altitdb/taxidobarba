package br.com.taxidobarba.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

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

@Service
public class FuelServiceBean {

    private static final Logger LOG = LogManager.getLogger(FuelServiceBean.class);
    
    @Autowired
    private FuelRepository repository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;
    
    public FuelResponseDTO save(FuelRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        
        LOG.info("Persistindo dados...");
        Fuel fuel = requestDtoToEntity(null, request);
        repository.save(fuel);
        LOG.info("Dados persistidos.");
        
        return entityToResponseDto(fuel);
        
    }
    
    public FuelResponseDTO find(String id) {
        Fuel fuel = findById(id);
        return entityToResponseDto(fuel);
    }


    public FuelResponseDTO update(String id, FuelRequestDTO request) {
    	LOG.info("Dados recebidos no request: {}", request);
    	Fuel fuel = findById(id);
    	requestDtoToEntity(fuel, request);
    	LOG.debug("Persistindo dados...");
    	repository.save(fuel);
    	LOG.debug("Dados persistidos.");
    	return entityToResponseDto(fuel);
    }
    
    private Fuel requestDtoToEntity(Fuel fuel, FuelRequestDTO request) {
        Car car = findCarById(request.getCar());
        Driver driver = findDriverById(request.getDriver());
        
        BigDecimal price = request.getPrice();
        BigDecimal liters = request.getLiters();
        BigDecimal fuelPrice = price.divide(liters, MathContext.DECIMAL32);
        
        Fuel.FuelBuilder builder = new Fuel.FuelBuilder();
        
        if(Objects.nonNull(fuel)) {
        	builder.forUpdate(fuel);
        }
        
		return builder
                .wihtCar(car)
                .withDate(request.getDate())
                .withDriver(driver)
                .withFuelPrice(fuelPrice)
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
                .withLiters(fuel.getLiters())
                .withPrice(fuel.getPrice())
                .build();
    }
    
    private Fuel findById(String id) {
    	LOG.info("Buscando fuel por id: {}", id);
    	Fuel fuel = repository.findById(id).orElseThrow(() -> new BusinessException("Registro não encontrado."));
    	return fuel;
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

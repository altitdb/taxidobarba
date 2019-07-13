package br.com.taxidobarba.service;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.CashRegisterCity;
import br.com.taxidobarba.domain.CashRegisterCity.CashRegisterCityBuilder;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.request.dto.CashRegisterCityRequestDTO;
import br.com.taxidobarba.domain.response.dto.CashRegisterCityResponseDTO;
import br.com.taxidobarba.domain.response.dto.SimpleCarResponseDTO;
import br.com.taxidobarba.domain.response.dto.SimpleDriverResponseDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.CashRegisterCityRepository;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.validator.RequestValidator;

@Service
public class CashRegisterCityServiceBean {

    private static final Logger LOG = LogManager.getLogger(CashRegisterCityServiceBean.class);
    
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CashRegisterCityRepository cashCityRepository;
    @Autowired
    private RequestValidator<CashRegisterCityRequestDTO> validator;
    
    public CashRegisterCityResponseDTO save(CashRegisterCityRequestDTO request) {
        
        validator.validateOnSave(request);
        
        CashRegisterCity cashRegisterCity = requestDtoToEntity(request);
        
        LOG.debug("Persistindo cashCity...");
        cashCityRepository.save(cashRegisterCity);
        LOG.debug("Dados persistidos.");
        
        return entityToResponseDto(cashRegisterCity);
    }

    public CashRegisterCityResponseDTO update(String id, CashRegisterCityRequestDTO request) {
        
        validator.validateOnUpdate(request, id);
        
        CashRegisterCity cashRegisterCity = findCashRegisterCityById(id);
        requestDtoToEntity(cashRegisterCity, request);
        
        LOG.debug("Persistindo cashCity...");
        cashCityRepository.save(cashRegisterCity);
        LOG.debug("Dados persistidos.");
        
        return entityToResponseDto(cashRegisterCity);
    }
    
    public CashRegisterCityResponseDTO find(String id) {
        LOG.info("Buscando city por id: {}", id);
        CashRegisterCity cashRegisterCity = cashCityRepository.findById(id).orElseThrow(() -> new BusinessException("Registro não encontrado."));
        return entityToResponseDto(cashRegisterCity);
    }
    
    private CashRegisterCity requestDtoToEntity(CashRegisterCityRequestDTO request) {
        return requestDtoToEntity(null, request);
    }
    
    private CashRegisterCity requestDtoToEntity(CashRegisterCity cashRegisterCity, CashRegisterCityRequestDTO request) {
        Car car = findCarById(request.getCar());
        Driver driver = findDriverById(request.getDriver());

        BigDecimal priceKmDriver = driver.getPriceKm();
        BigDecimal startKm = request.getStartKm();
        BigDecimal endKm = request.getEndKm();
        BigDecimal otherKm = request.getOtherKm();
        BigDecimal km = calculateKm(startKm, endKm, otherKm);
        BigDecimal price = calculatePrice(endKm, startKm, otherKm, priceKmDriver);
        BigDecimal totalReceived = request.getTotalReceived();
        BigDecimal difference = calculateDifference(totalReceived, price);
        
        CashRegisterCityBuilder builder = new CashRegisterCityBuilder();
        
        if(cashRegisterCity != null) {
            builder = builder.forUpdate(cashRegisterCity);
        }
        
        return builder.withCar(car)
                      .withPrice(price)
                      .withPriceKmDriver(priceKmDriver)
                      .withDate(request.getDate())
                      .withDriver(driver)
                      .withEndKm(endKm)
                      .withOtherKm(otherKm)
                      .withStartKm(startKm)
                      .withKm(km)
                      .withTotalReceived(totalReceived)
                      .withDifference(difference)
                      .build();
    }
    
    private CashRegisterCityResponseDTO entityToResponseDto(CashRegisterCity city) {
        SimpleCarResponseDTO carDto = new SimpleCarResponseDTO(city.getCar());
        SimpleDriverResponseDTO driverDto = new SimpleDriverResponseDTO(city.getDriver());
        
        return new CashRegisterCityResponseDTO.CashRegisterCityResponseBuilder()
                .withCar(carDto)
                .withDriver(driverDto)
                .withDate(city.getDate())
                .withDifference(city.getDifference())
                .withEndKm(city.getEndKm())
                .withKm(city.getKm())
                .withOtherKm(city.getOtherKm())
                .withPrice(city.getPrice())
                .withPriceKmDriver(city.getPriceKmDriver())
                .withStartKm(city.getStartKm())
                .withTotalReceived(city.getTotalReceived())
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
    
    private CashRegisterCity findCashRegisterCityById(String id) {
        return cashCityRepository.findById(id)
                .orElseThrow(() -> new BusinessException("CashRegisterCity nao localizado."));
    }
    
    private BigDecimal calculatePrice(BigDecimal endKm, BigDecimal startKm, BigDecimal otherKm,
            BigDecimal priceKmDriver) {
        return (endKm.subtract(startKm).subtract(otherKm)).multiply(priceKmDriver, MathContext.DECIMAL32);
    }
    
    private BigDecimal calculateKm(BigDecimal startKm, BigDecimal endKm, BigDecimal otherKm) {
        return (endKm.subtract(startKm)).subtract(otherKm);
    }
    
    private BigDecimal calculateDifference(BigDecimal totalReceived, BigDecimal price) {
        return totalReceived.subtract(price);
    }

}

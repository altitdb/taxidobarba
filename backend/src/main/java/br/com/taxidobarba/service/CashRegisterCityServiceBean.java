package br.com.taxidobarba.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.CashRegisterCity;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.dto.CarCashRegisterDTO;
import br.com.taxidobarba.domain.dto.CashRegisterCityRequestDTO;
import br.com.taxidobarba.domain.dto.CashRegisterCityResponseDTO;
import br.com.taxidobarba.domain.dto.DriverCashRegisterDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.CashRegisterCityRepository;
import br.com.taxidobarba.repository.DriverRepository;

@Service
public class CashRegisterCityServiceBean implements CashRegisterCityService {

    private static final Logger LOG = LogManager.getLogger(CashRegisterCityServiceBean.class);
    
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CashRegisterCityRepository cashCityRepository;
    
    @Override
    public CashRegisterCityResponseDTO save(CashRegisterCityRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        validateRequest(request);
        CashRegisterCity cashRegisterCity = cashRegisterCityRequestDtoToEntity(request);
        LOG.info("Persistindo cashCity...");
        CashRegisterCity city = cashCityRepository.save(cashRegisterCity);
        LOG.info("Dados persistidos.");
        
        return entityToResponseDto(city);
        
    }

    private CashRegisterCity cashRegisterCityRequestDtoToEntity(CashRegisterCityRequestDTO request) {
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
        
        return new CashRegisterCity.CashRegisterCityBuilder()
                                .withCar(car)
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
        CarCashRegisterDTO carDto = createCarCashRegisterDTO(city.getCar());
        DriverCashRegisterDTO driverDto = createDriverCashRegisterDTO(city.getDriver());
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
    
    private CarCashRegisterDTO createCarCashRegisterDTO(Car car) {
        return new CarCashRegisterDTO.CarCashRegisterBuilder()
                    .withId(car.getId())
                    .withName(car.getName())
                    .build();
    }
    
    private DriverCashRegisterDTO createDriverCashRegisterDTO(Driver driver) {
        return new DriverCashRegisterDTO.DriverCashRegisterBuilder()
                    .withId(driver.getId())
                    .withName(driver.getName())
                    .build();
    }
    
    private void validateRequest(CashRegisterCityRequestDTO request) {
        validateKm(request.getStartKm(), request.getEndKm());
        validateRegisterByDateAndDriver(request.getDriver(), request.getDate());
    }
    
    private void validateKm(BigDecimal startKm, BigDecimal endKm) {
        if (startKm.compareTo(endKm) > 0)
            throw new BusinessException("KM inicial nao pode ser maior que KM final.");
    }
    
    private void validateRegisterByDateAndDriver(String driverId, LocalDate date) {
        Driver driver = findDriverById(driverId);
        cashCityRepository.findByDriverAndDate(driver, date).ifPresent(city -> {
            throw new BusinessException("Ja existe um registro para essa data e motorista");
        });
    }
    
    private Car findCarById(String id) {
        LOG.info("Buscando carro...");
        return carRepository.findById(id).orElseThrow(() -> new BusinessException("Carro nao localizado."));
    }

    private Driver findDriverById(String id) {
        LOG.info("Buscando motorista...");
        return driverRepository.findById(id).orElseThrow(() -> new BusinessException("Motorista nao localizado."));
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

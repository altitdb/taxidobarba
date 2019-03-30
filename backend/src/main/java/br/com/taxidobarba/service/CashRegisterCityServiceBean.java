package br.com.taxidobarba.service;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.CashRegisterCity;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.dto.CashRegisterCityRequestDTO;
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
    public void save(CashRegisterCityRequestDTO request) {
        LOG.info("Dados recebidos no request: " + request);
        validateRequest(request);
        CashRegisterCity cashRegisterCity = cashRegisterCityRequestDtoToEntity(request);
        LOG.info("Persistindo cashCity...");
        cashCityRepository.save(cashRegisterCity);
        LOG.info("Dados persistidos.");
    }

    private CashRegisterCity cashRegisterCityRequestDtoToEntity(CashRegisterCityRequestDTO request) {
        Car car = findCarById(request.getCarId());
        Driver driver = findDriverById(request.getDriverId());

        BigDecimal priceKmDriver = request.getPriceKmDriver();
        BigDecimal startKm = request.getStartKm();
        BigDecimal endKm = request.getEndKm();
        BigDecimal otherKm = request.getOtherKm();
        BigDecimal price = calculatePrice(endKm, startKm, otherKm, priceKmDriver);

        return new CashRegisterCity.CashRegisterCityBuilder()
                                .withCar(car)
                                .withPrice(price)
                                .withDate(request.getDate())
                                .withDriver(driver)
                                .withKm(request.getKm())
                                .withDifference(request.getDifference())
                                .withEndKm(endKm)
                                .withOtherKm(otherKm)
                                .withPriceKmDriver(priceKmDriver)
                                .withStartKm(startKm)
                                .withTotalReceived(request.getTotalReceived())
                                .build();
    }
    
    private void validateRequest(CashRegisterCityRequestDTO request) {
        if (request.getStartKm().compareTo(request.getEndKm()) > 0)
            throw new BusinessException("KM inicial nao pode ser maior que KM final.");
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
}

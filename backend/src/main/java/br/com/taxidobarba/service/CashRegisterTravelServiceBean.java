package br.com.taxidobarba.service;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.CashRegisterTravel;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.dto.CashRegisterTravelRequestDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.CashRegisterTravelRepository;
import br.com.taxidobarba.repository.DriverRepository;

@Service
public class CashRegisterTravelServiceBean implements CashRegisterTravelService {

    private static final Logger LOG = LogManager.getLogger(CashRegisterTravelServiceBean.class);

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CashRegisterTravelRepository cashTravelRepository;

    @Override
    public void save(CashRegisterTravelRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        CashRegisterTravel cashRegisterTravel = cashRegisterTravelRequestDtoToEntity(request);
        LOG.info("Persistindo cashTravel...");
        cashTravelRepository.save(cashRegisterTravel);
        LOG.info("Dados persistidos.");
    }

    private CashRegisterTravel cashRegisterTravelRequestDtoToEntity(CashRegisterTravelRequestDTO request) {
        Car car = findCarById(request.getCarId());
        Driver driver = findDriverById(request.getDriverId());

        BigDecimal price = request.getPrice();
        BigDecimal percentualDriver = request.getPercentualDriver();
        BigDecimal km = request.getKm();
        BigDecimal valueDriver = calculateValueDriver(price, percentualDriver);
        BigDecimal averagePriceKm = calculateAveragePriceKm(price, km);
        BigDecimal netValue = price.subtract(valueDriver);

        return new CashRegisterTravel.CashRegisterTravelBuilder()
                                .withCar(car)
                                .withAveragePriceKm(averagePriceKm)
                                .withCity(request.getCity())
                                .withDate(request.getDate())
                                .withDriver(driver)
                                .withKm(km)
                                .withNetValue(netValue)
                                .withPercentualDriver(percentualDriver)
                                .withPrice(price)
                                .withValueDriver(valueDriver)
                                .build();
    }

    private BigDecimal calculateValueDriver(BigDecimal price, BigDecimal percentualDriver) {
        LOG.info("Calculando valor motorista...");
        return price.multiply((percentualDriver).divide(new BigDecimal(100), MathContext.DECIMAL32));
    }

    private BigDecimal calculateAveragePriceKm(BigDecimal price, BigDecimal km) {
        LOG.info("Calculando preco medio por km...");
        return price.divide(km, MathContext.DECIMAL32);
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

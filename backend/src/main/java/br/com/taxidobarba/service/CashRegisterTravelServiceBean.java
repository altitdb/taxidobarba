package br.com.taxidobarba.service;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.CashRegisterTravel;
import br.com.taxidobarba.domain.CashRegisterTravel.CashRegisterTravelBuilder;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.request.dto.CashRegisterTravelRequestDTO;
import br.com.taxidobarba.domain.response.dto.CashRegisterTravelResponseDTO;
import br.com.taxidobarba.domain.response.dto.SimpleCarResponseDTO;
import br.com.taxidobarba.domain.response.dto.SimpleDriverResponseDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.CashRegisterTravelRepository;
import br.com.taxidobarba.repository.DriverRepository;

@Service
public class CashRegisterTravelServiceBean {

    private static final Logger LOG = LogManager.getLogger(CashRegisterTravelServiceBean.class);

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CashRegisterTravelRepository cashTravelRepository;

    public CashRegisterTravelResponseDTO save(CashRegisterTravelRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        
        CashRegisterTravel cashRegisterTravel = requestDtoToEntity(request);
        
        LOG.info("Persistindo cashTravel...");
        cashTravelRepository.save(cashRegisterTravel);
        LOG.info("Dados persistidos.");
        
        return entityToResponseDto(cashRegisterTravel);
    }
    
    public CashRegisterTravelResponseDTO update(String id, CashRegisterTravelRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        
        CashRegisterTravel travel = findCashRegisterTravelById(id);
        
        requestDtoToEntity(travel, request);
        
        LOG.info("Persistindo cashTravel...");
        cashTravelRepository.save(travel);
        LOG.info("Dados persistidos.");
        
        return entityToResponseDto(travel);
    }
    
    public CashRegisterTravelResponseDTO find(String id) {
        LOG.info("Buscando travel por id: {}", id);
        CashRegisterTravel cashRegisterTravel = cashTravelRepository.findById(id).orElseThrow(() -> new BusinessException("Registro não encontrado."));
        return entityToResponseDto(cashRegisterTravel);
    }
    
    private CashRegisterTravel requestDtoToEntity(CashRegisterTravelRequestDTO request) {
        return requestDtoToEntity(null, request);
    }

    private CashRegisterTravel requestDtoToEntity(CashRegisterTravel travel, CashRegisterTravelRequestDTO request) {
        Car car = findCarById(request.getCar());
        Driver driver = findDriverById(request.getDriver());

        BigDecimal price = request.getPrice();
        BigDecimal percentualDriver = driver.getPercentualTravel();
        BigDecimal km = request.getKm();
        BigDecimal valueDriver = calculateValueDriver(price, percentualDriver);
        BigDecimal averagePriceKm = calculateAveragePriceKm(price, km);
        BigDecimal netValue = price.subtract(valueDriver);

        CashRegisterTravelBuilder builder = new CashRegisterTravelBuilder();
        
        if(travel != null) {
            builder = builder.forUpdate(travel);
        }
        
        return builder.withCar(car)
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

    private CashRegisterTravelResponseDTO entityToResponseDto(CashRegisterTravel travel) {
        SimpleCarResponseDTO carDto = new SimpleCarResponseDTO(travel.getCar());
        SimpleDriverResponseDTO driverDto = new SimpleDriverResponseDTO(travel.getDriver());
        
        return new CashRegisterTravelResponseDTO.CashRegisterTravelResponseBuilder()
                .withAveragePriceKm(travel.getAveragePriceKm())
                .withCar(carDto)
                .withCity(travel.getCity())
                .withDate(travel.getDate())
                .withDriver(driverDto)
                .withKm(travel.getKm())
                .withNetValue(travel.getNetValue())
                .withPercentualDriver(travel.getPercentualDriver())
                .withPrice(travel.getPrice())
                .withValueDriver(travel.getValueDriver())
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
    
    private CashRegisterTravel findCashRegisterTravelById(String id) {
        LOG.info("Buscando travel...");
        return cashTravelRepository.findById(id).orElseThrow(() -> new BusinessException("CashRegisterTravel nao localizado."));
    }

}

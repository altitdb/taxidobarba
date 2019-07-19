package br.com.taxidobarba.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.DriverRepository;

public abstract class CashRegisterValidator {

    private static final Logger LOG = LogManager.getLogger(CashRegisterValidator.class);

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;

    protected Car findCarById(String id) {
        LOG.debug("Buscando carro...");
        return carRepository.findById(id).orElseThrow(() -> new BusinessException("Carro nao localizado pelo id: " + id));
    }

    protected Driver findDriverById(String id) {
        LOG.debug("Buscando motorista...");
        return driverRepository.findById(id).orElseThrow(() -> new BusinessException("Motorista nao localizado pelo id: " + id));
    }

}

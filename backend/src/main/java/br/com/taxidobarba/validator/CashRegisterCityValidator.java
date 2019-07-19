package br.com.taxidobarba.validator;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.taxidobarba.domain.CashRegisterCity;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.request.dto.CashRegisterCityRequestDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.CashRegisterCityRepository;

@Component
public class CashRegisterCityValidator extends CashRegisterValidator
        implements RequestValidator<CashRegisterCityRequestDTO> {

    private static final Logger LOG = LogManager.getLogger(CashRegisterCityValidator.class);

    @Autowired
    private CashRegisterCityRepository cashCityRepository;

    @Override
    public void validateOnSave(CashRegisterCityRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        
        validateKm(request.getStartKm(), request.getEndKm());
        validateRegisterByDateAndDriver(request.getDriver(), request.getDate());
    }

    @Override
    public void validateOnUpdate(CashRegisterCityRequestDTO request, String id) {
        LOG.info("Dados recebidos no request: {}", request);
        LOG.info("ID recebido no request: {}", id);
        
        validateKm(request.getStartKm(), request.getEndKm());
        
        CashRegisterCity cashRegisterCity = findCashRegisterCityById(id);
        String driver = cashRegisterCity.getDriver().getId();
        LocalDate date = cashRegisterCity.getDate();
        String cashRegisterId = cashRegisterCity.getId();
        validateRegisterByDateAndDriverAndId(driver, date, cashRegisterId);

    }

    private void validateKm(BigDecimal startKm, BigDecimal endKm) {
        if (startKm.compareTo(endKm) > 0)
            throw new BusinessException("KM inicial nao pode ser maior que KM final.");
    }

    private void validateRegisterByDateAndDriver(String driverId, LocalDate date) {
        Driver driver = findDriverById(driverId);
        cashCityRepository.findByDriverAndDate(driver, date).ifPresent(city -> {
            throw new BusinessException("Ja existe um registro para essa data e motorista.");
        });
    }
    
    private void validateRegisterByDateAndDriverAndId(String driverId, LocalDate date, String cashRegisterId) {
        Driver driver = findDriverById(driverId);
        cashCityRepository.findByDriverAndDateAndIdNot(driver, date, cashRegisterId).ifPresent(city -> {
            throw new BusinessException("Ja existe um registro para essa data e motorista");
        });
    }
    
    private CashRegisterCity findCashRegisterCityById(String id) {
        return cashCityRepository.findById(id)
                .orElseThrow(() -> new BusinessException("CashRegisterCity nao localizado."));
    }
}

package br.com.taxidobarba.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import br.com.taxidobarba.domain.request.dto.CashRegisterTravelRequestDTO;

@Component
public class CashRegisterTravelValidator extends CashRegisterValidator
        implements RequestValidator<CashRegisterTravelRequestDTO> {

    private static final Logger LOG = LogManager.getLogger(CashRegisterTravelValidator.class);

    @Override
    public void validateOnSave(CashRegisterTravelRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        validateCar(request.getCar());
        validateDriver(request.getDriver());
    }

    @Override
    public void validateOnUpdate(CashRegisterTravelRequestDTO request, String id) {
        LOG.info("Dados recebidos no request: {}", request);
        LOG.info("ID recebido no request: {}", id);

        validateCar(request.getCar());
        validateDriver(request.getDriver());
    }

    private void validateCar(String id) {
        LOG.debug("Validando carro...");
        findCarById(id);
    }

    private void validateDriver(String id) {
        LOG.debug("Validando motorista...");
        findDriverById(id);
    }

}

package br.com.taxidobarba.validator;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import br.com.taxidobarba.domain.request.dto.TrafficTicketRequestDTO;
import br.com.taxidobarba.exception.BusinessException;

@Component
public class TrafficTicketValidator implements RequestValidator<TrafficTicketRequestDTO> {

    private static final Logger LOG = LogManager.getLogger(TrafficTicketValidator.class);
    private static final List<Integer> VALID_POINTS = Arrays.asList(3, 4, 5, 7);

    @Override
    public void validateOnSave(TrafficTicketRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);

        validatePoints(request.getPoints());
    }

    private void validatePoints(Integer points) {

        if (!VALID_POINTS.contains(points)) {
            throw new BusinessException("Valor inválido para pontos. Valores válidos: " + VALID_POINTS);
        }

    }

}

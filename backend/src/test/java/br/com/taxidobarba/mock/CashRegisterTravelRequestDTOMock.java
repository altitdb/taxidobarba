package br.com.taxidobarba.mock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import br.com.taxidobarba.domain.request.dto.CashRegisterTravelRequestDTO;

public class CashRegisterTravelRequestDTOMock extends GenericRequestDTOMock {

    public static CashRegisterTravelRequestDTO mock() {

        CashRegisterTravelRequestDTO cashRegisterTravelRequestDto = new CashRegisterTravelRequestDTO();

        Map<String, Object> attributes = new HashMap<>();

        attributes.put("car", "asct9547dg41");
        attributes.put("driver", "asct9547dg41");
        attributes.put("city", "Londrina");
        attributes.put("price", new BigDecimal(25));
        attributes.put("km", new BigDecimal(158.6));
        attributes.put("date", LocalDate.now());

        return createRequestDto(cashRegisterTravelRequestDto, attributes);
    }

}

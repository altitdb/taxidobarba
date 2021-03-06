package br.com.taxidobarba.mock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import br.com.taxidobarba.domain.request.dto.CashRegisterCityRequestDTO;

public class CashRegisterCityRequestDTOMock extends GenericRequestDTOMock {

    public static CashRegisterCityRequestDTO mockSuccess() {

        CashRegisterCityRequestDTO cashRegisterCityRequestDto = new CashRegisterCityRequestDTO();

        Map<String, Object> attributes = new HashMap<>();

        attributes.put("car", "asct9547dg41");
        attributes.put("driver", "Werbn980023lo");
        attributes.put("totalReceived", new BigDecimal(250));
        attributes.put("date", LocalDate.now());
        attributes.put("startKm", new BigDecimal(5000));
        attributes.put("endKm", new BigDecimal(6000));
        attributes.put("otherKm", new BigDecimal(5));

        return createRequestDto(cashRegisterCityRequestDto, attributes);
    }
    
    public static CashRegisterCityRequestDTO mockFail() {

        CashRegisterCityRequestDTO cashRegisterCityRequestDto = new CashRegisterCityRequestDTO();

        Map<String, Object> attributes = new HashMap<>();

        attributes.put("car", "asct9547dg41");
        attributes.put("driver", "Werbn980023lo");
        attributes.put("totalReceived", new BigDecimal(250));
        attributes.put("date", LocalDate.now());
        attributes.put("startKm", new BigDecimal(5000));
        attributes.put("endKm", new BigDecimal(2000));
        attributes.put("otherKm", new BigDecimal(5));

        return createRequestDto(cashRegisterCityRequestDto, attributes);
    }

}

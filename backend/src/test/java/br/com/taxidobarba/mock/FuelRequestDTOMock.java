package br.com.taxidobarba.mock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import br.com.taxidobarba.domain.request.dto.FuelRequestDTO;

public class FuelRequestDTOMock extends GenericRequestDTOMock{

    public static FuelRequestDTO mock() {

        FuelRequestDTO fuelRequestDTO = new FuelRequestDTO();
        
        Map<String, Object> attributes = new HashMap<>();

        attributes.put("km", BigDecimal.ONE);
        attributes.put("liters", BigDecimal.TEN);
        attributes.put("price", BigDecimal.ONE);
        attributes.put("date", LocalDate.now());
        attributes.put("car", "aptoy548erfd21");
        attributes.put("driver", "aptoy548erfd21");
        
        return createRequestDto(fuelRequestDTO, attributes);

    }

}

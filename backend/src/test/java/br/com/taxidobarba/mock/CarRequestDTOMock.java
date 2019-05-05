package br.com.taxidobarba.mock;

import java.util.HashMap;
import java.util.Map;

import br.com.taxidobarba.domain.request.dto.CarRequestDTO;

public class CarRequestDTOMock extends GenericRequestDTOMock {

    public static CarRequestDTO mock() {

        CarRequestDTO carRequestDTO = new CarRequestDTO();

        Map<String, Object> attributes = new HashMap<>();

        attributes.put("name", "Gol");
        attributes.put("licensePlate", "77683955060");

        return createRequestDto(carRequestDTO, attributes);

    }

}

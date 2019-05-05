package br.com.taxidobarba.mock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import br.com.taxidobarba.domain.request.dto.TrafficTicketRequestDTO;

public class TrafficTicketRequestDTOMock extends GenericRequestDTOMock {

    public static TrafficTicketRequestDTO mockFail() {
        TrafficTicketRequestDTO trafficTicketRequestDto = new TrafficTicketRequestDTO();

        Map<String, Object> attributes = new HashMap<>();

        attributes.put("car", "asct9547dg41");
        attributes.put("driver", "asct9547dg41");
        attributes.put("value", new BigDecimal(25));
        attributes.put("points", 10);
        attributes.put("dueDate", LocalDate.now());

        return createRequestDto(trafficTicketRequestDto, attributes);
    }
    
    public static TrafficTicketRequestDTO mockSuccess() {
        TrafficTicketRequestDTO trafficTicketRequestDto = new TrafficTicketRequestDTO();

        Map<String, Object> attributes = new HashMap<>();

        attributes.put("car", "asct9547dg41");
        attributes.put("driver", "asct9547dg41");
        attributes.put("value", new BigDecimal(25));
        attributes.put("points", 5);
        attributes.put("dueDate", LocalDate.now());

        return createRequestDto(trafficTicketRequestDto, attributes);
    }

}

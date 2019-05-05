package br.com.taxidobarba.mock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import br.com.taxidobarba.domain.request.dto.PaymentTrafficTicketRequestDTO;

public class PaymentTrafficTicketRequestDTOMock extends GenericRequestDTOMock {

    public static PaymentTrafficTicketRequestDTO mockSuccess() {
        PaymentTrafficTicketRequestDTO paymentTrafficTicketRequestDto = new PaymentTrafficTicketRequestDTO();

        Map<String, Object> attributes = new HashMap<>();

        attributes.put("trafficTicketId", "asct9547dg41");
        attributes.put("value", new BigDecimal(125));
        attributes.put("date", LocalDate.now());

        return createRequestDto(paymentTrafficTicketRequestDto, attributes);
    }
    
    public static PaymentTrafficTicketRequestDTO mockFail() {
        PaymentTrafficTicketRequestDTO paymentTrafficTicketRequestDto = new PaymentTrafficTicketRequestDTO();

        Map<String, Object> attributes = new HashMap<>();

        attributes.put("trafficTicketId", "asct9547dg41");
        attributes.put("value", new BigDecimal(11125));
        attributes.put("date", LocalDate.now().plusDays(2L));

        return createRequestDto(paymentTrafficTicketRequestDto, attributes);
    }

}

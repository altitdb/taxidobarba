package br.com.taxidobarba.mock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import br.com.taxidobarba.domain.request.dto.DriverRequestDTO;

public class DriverResquestDTOMock extends GenericRequestDTOMock{

    public static DriverRequestDTO mock() {

        DriverRequestDTO driverRequestDto = new DriverRequestDTO();

        Map<String, Object> attributes = new HashMap<>();

        attributes.put("name", "Taxista A");
        attributes.put("fullName", "Taxista A da Silva");
        attributes.put("taxIdentifier", "77683955060");
        attributes.put("nationalRegister", "123456");
        attributes.put("birthDate", LocalDate.of(1980, 01, 20));
        attributes.put("licenseNumber", "1254798");
        attributes.put("priceKm", BigDecimal.TEN);
        attributes.put("percentualTravel", BigDecimal.TEN);
        attributes.put("licenseDueDate", LocalDate.of(2022, 01, 20));
        attributes.put("enable", Boolean.TRUE);

        return createRequestDto(driverRequestDto, attributes);
    }
}

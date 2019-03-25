package br.com.taxidobarba.mock;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.taxidobarba.domain.dto.DriverResponseDTO;

public class DriverResponseDTOMock {

    public static DriverResponseDTO mockDriverResponseDto() {
        return new DriverResponseDTO.DriverResponseBuilder()
                    .withBirthDate(LocalDate.of(1990, 04, 20))
                    .withId("ASD121548")
                    .withLicenseDueDate(LocalDate.of(2020, 04, 20))
                    .isEnable(Boolean.TRUE)
                    .withLicenseNumber("123456")
                    .withName("JOSE")
                    .withNationalRegister("45548787878")
                    .withPriceKm(BigDecimal.TEN)
                    .withTaxIdentifier("0895478425")
                    .build();
    }

}

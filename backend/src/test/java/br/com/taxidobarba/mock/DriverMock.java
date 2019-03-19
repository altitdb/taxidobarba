package br.com.taxidobarba.mock;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.taxidobarba.domain.Driver;

public class DriverMock {

    public static Driver mockDriver() {
        return new Driver.DriverBuilder()
                    .isEnable(Boolean.TRUE)
                    .withBirthDate(LocalDate.of(1980, 01, 20))
                    .withLicenseDueDate(LocalDate.of(2022, 01, 20))
                    .withLicenseNumber("123456").withName("JOSE")
                    .withNationalRegister("123545")
                    .withPriceKm(BigDecimal.TEN)
                    .withTaxIdentifier("77683955060")
                    .build();
    }

}

package br.com.taxidobarba.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class CashRegisterCityRequestDTO {

    @NotNull
    private String carId;
    @NotNull
    private String driverId;
    @DecimalMin(value = "0.01")
    private BigDecimal totalReceived;
    @NotNull
    private LocalDate date;
    private BigDecimal startKm;
    @DecimalMin(value = "0.01")
    private BigDecimal endKm;
    private BigDecimal otherKm;

    public String getCarId() {
        return carId;
    }

    public String getDriverId() {
        return driverId;
    }

    public BigDecimal getTotalReceived() {
        return totalReceived;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getStartKm() {
        return startKm;
    }

    public BigDecimal getEndKm() {
        return endKm;
    }

    public BigDecimal getOtherKm() {
        return otherKm;
    }

    @Override
    public String toString() {
        return "CashRegisterCityRequestDTO [carId=" + carId + ", driverId=" + driverId + ", totalReceived="
                + totalReceived + ", date=" + date + ", startKm=" + startKm + ", endKm=" + endKm + ", otherKm="
                + otherKm + "]";
    }

}

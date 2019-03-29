package br.com.taxidobarba.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class FuelRequestDTO {

    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal km;
    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal liters;
    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal price;
    @NotNull
    private LocalDate date;
    @NotNull
    private String carId;
    @NotNull
    private String driverId;

    public BigDecimal getKm() {
        return km;
    }

    public BigDecimal getLiters() {
        return liters;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCarId() {
        return carId;
    }

    public String getDriverId() {
        return driverId;
    }

    @Override
    public String toString() {
        return "FuelResquestDTO [km=" + km + ", liters=" + liters + ", price=" + price + ", date=" + date + ", carId="
                + carId + ", driverId=" + driverId + "]";
    }

}

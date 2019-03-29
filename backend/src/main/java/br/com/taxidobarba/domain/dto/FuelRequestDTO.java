package br.com.taxidobarba.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuelResquestDTO {

    private BigDecimal km;
    private BigDecimal liters;
    private BigDecimal price;
    private LocalDate date;
    private String carId;
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

}

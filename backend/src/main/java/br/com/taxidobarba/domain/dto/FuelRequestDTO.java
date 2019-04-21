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
    private String car;
    @NotNull
    private String driver;

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

    public String getCar() {
        return car;
    }

    public String getDriver() {
        return driver;
    }

    @Override
    public String toString() {
        return "FuelRequestDTO [km=" + km + ", liters=" + liters + ", price=" + price + ", date=" + date + ", car="
                + car + ", driver=" + driver + "]";
    }

}

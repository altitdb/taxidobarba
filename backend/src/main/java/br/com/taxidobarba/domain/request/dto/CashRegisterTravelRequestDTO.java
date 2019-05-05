package br.com.taxidobarba.domain.request.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class CashRegisterTravelRequestDTO {

    @NotNull
    private String car;
    @NotNull
    private String driver;
    private String city;
    @NotNull
    private BigDecimal price;
    @DecimalMin(value = "0.01")
    private BigDecimal km;
    private LocalDate date;

    public String getCar() {
        return car;
    }

    public String getDriver() {
        return driver;
    }

    public String getCity() {
        return city;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getKm() {
        return km;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "CashRegisterTravelRequestDTO [car=" + car + ", driver=" + driver + ", city=" + city + ", price=" + price
                + ", km=" + km + ", date=" + date + "]";
    }

}

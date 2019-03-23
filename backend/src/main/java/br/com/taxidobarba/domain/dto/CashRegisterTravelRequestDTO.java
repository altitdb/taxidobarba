package br.com.taxidobarba.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class CashRegisterTravelRequestDTO {

    @NotNull
    private String carId;
    @NotNull
    private String driverId;
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100")
    private BigDecimal percentualDriver;
    private String city;
    @NotNull
    private BigDecimal price;
    @DecimalMin(value = "0.01")
    private BigDecimal km;
    private LocalDate date;

    public String getCarId() {
        return carId;
    }

    public String getDriverId() {
        return driverId;
    }

    public BigDecimal getPercentualDriver() {
        return percentualDriver;
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
        return "CashRegisterTravelRequestDTO [carId=" + carId + ", driverId=" + driverId + ", percentualDriver="
                + percentualDriver + ", city=" + city + ", price=" + price + ", km=" + km + ", date=" + date + "]";
    }
}

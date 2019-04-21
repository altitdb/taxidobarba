package br.com.taxidobarba.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuelResponseDTO {

    private BigDecimal km;
    private BigDecimal liters;
    private BigDecimal price;
    private BigDecimal fuelPrice;
    private LocalDate date;
    private SimpleCarResponseDTO car;
    private SimpleDriverResponseDTO driver;

    public static class FuelResponseBuilder {

        private FuelResponseDTO dto;

        public FuelResponseBuilder() {
            dto = new FuelResponseDTO();
        }

        public FuelResponseBuilder withKm(BigDecimal km) {
            dto.km = km;
            return this;
        }

        public FuelResponseBuilder withLiters(BigDecimal liters) {
            dto.liters = liters;
            return this;
        }

        public FuelResponseBuilder withPrice(BigDecimal price) {
            dto.price = price;
            return this;
        }

        public FuelResponseBuilder withFuelPrice(BigDecimal fuelPrice) {
            dto.fuelPrice = fuelPrice;
            return this;
        }

        public FuelResponseBuilder withDate(LocalDate date) {
            dto.date = date;
            return this;
        }

        public FuelResponseBuilder wihtCar(SimpleCarResponseDTO car) {
            dto.car = car;
            return this;
        }

        public FuelResponseBuilder withDriver(SimpleDriverResponseDTO driver) {
            dto.driver = driver;
            return this;
        }

        public FuelResponseDTO build() {
            return dto;
        }

    }

    public BigDecimal getKm() {
        return km;
    }

    public BigDecimal getLiters() {
        return liters;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getFuelPrice() {
        return fuelPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public SimpleCarResponseDTO getCar() {
        return car;
    }

    public SimpleDriverResponseDTO getDriver() {
        return driver;
    }

}

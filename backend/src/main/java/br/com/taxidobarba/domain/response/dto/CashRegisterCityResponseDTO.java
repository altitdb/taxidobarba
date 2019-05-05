package br.com.taxidobarba.domain.response.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CashRegisterCityResponseDTO {

    private SimpleCarResponseDTO car;
    private SimpleDriverResponseDTO driver;
    private BigDecimal priceKmDriver;
    private BigDecimal km;
    private BigDecimal price;
    private BigDecimal totalReceived;
    private BigDecimal difference;
    private LocalDate date;
    private BigDecimal startKm;
    private BigDecimal endKm;
    private BigDecimal otherKm;

    public static class CashRegisterCityResponseBuilder {

        private CashRegisterCityResponseDTO dto;

        public CashRegisterCityResponseBuilder() {
            dto = new CashRegisterCityResponseDTO();
        }

        public CashRegisterCityResponseBuilder withCar(SimpleCarResponseDTO car) {
            dto.car = car;
            return this;
        }

        public CashRegisterCityResponseBuilder withDriver(SimpleDriverResponseDTO driver) {
            dto.driver = driver;
            return this;
        }

        public CashRegisterCityResponseBuilder withPriceKmDriver(BigDecimal priceKmDriver) {
            dto.priceKmDriver = priceKmDriver;
            return this;
        }

        public CashRegisterCityResponseBuilder withKm(BigDecimal km) {
            dto.km = km;
            return this;
        }

        public CashRegisterCityResponseBuilder withPrice(BigDecimal price) {
            dto.price = price;
            return this;
        }

        public CashRegisterCityResponseBuilder withTotalReceived(BigDecimal totalReceived) {
            dto.totalReceived = totalReceived;
            return this;
        }

        public CashRegisterCityResponseBuilder withDifference(BigDecimal difference) {
            dto.difference = difference;
            return this;
        }

        public CashRegisterCityResponseBuilder withDate(LocalDate date) {
            dto.date = date;
            return this;
        }

        public CashRegisterCityResponseBuilder withStartKm(BigDecimal startKm) {
            dto.startKm = startKm;
            return this;
        }

        public CashRegisterCityResponseBuilder withEndKm(BigDecimal endKm) {
            dto.endKm = endKm;
            return this;
        }

        public CashRegisterCityResponseBuilder withOtherKm(BigDecimal otherKm) {
            dto.otherKm = otherKm;
            return this;
        }

        public CashRegisterCityResponseDTO build() {
            return dto;
        }
    }

    public SimpleCarResponseDTO getCar() {
        return car;
    }

    public SimpleDriverResponseDTO getDriver() {
        return driver;
    }

    public BigDecimal getPriceKmDriver() {
        return priceKmDriver;
    }

    public BigDecimal getKm() {
        return km;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotalReceived() {
        return totalReceived;
    }

    public BigDecimal getDifference() {
        return difference;
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

}

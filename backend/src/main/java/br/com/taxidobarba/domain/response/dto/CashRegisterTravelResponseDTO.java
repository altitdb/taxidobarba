package br.com.taxidobarba.domain.response.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CashRegisterTravelResponseDTO {

    private SimpleCarResponseDTO car;
    private SimpleDriverResponseDTO driver;
    private BigDecimal percentualDriver;
    private BigDecimal valueDriver;
    private String city;
    private BigDecimal price;
    private BigDecimal netValue;
    private BigDecimal km;
    private BigDecimal averagePriceKm;
    private LocalDate date;

    public static class CashRegisterTravelResponseBuilder {

        CashRegisterTravelResponseDTO dto;

        public CashRegisterTravelResponseBuilder() {
            dto = new CashRegisterTravelResponseDTO();
        }

        public CashRegisterTravelResponseBuilder withCar(SimpleCarResponseDTO car) {
            dto.car = car;
            return this;
        }

        public CashRegisterTravelResponseBuilder withDriver(SimpleDriverResponseDTO driver) {
            dto.driver = driver;
            return this;
        }

        public CashRegisterTravelResponseBuilder withPercentualDriver(BigDecimal percentualDriver) {
            dto.percentualDriver = percentualDriver;
            return this;
        }

        public CashRegisterTravelResponseBuilder withValueDriver(BigDecimal valueDriver) {
            dto.valueDriver = valueDriver;
            return this;
        }

        public CashRegisterTravelResponseBuilder withCity(String city) {
            dto.city = city;
            return this;
        }

        public CashRegisterTravelResponseBuilder withPrice(BigDecimal price) {
            dto.price = price;
            return this;
        }

        public CashRegisterTravelResponseBuilder withNetValue(BigDecimal netValue) {
            dto.netValue = netValue;
            return this;
        }

        public CashRegisterTravelResponseBuilder withKm(BigDecimal km) {
            dto.km = km;
            return this;
        }

        public CashRegisterTravelResponseBuilder withAveragePriceKm(BigDecimal averagePriceKm) {
            dto.averagePriceKm = averagePriceKm;
            return this;
        }

        public CashRegisterTravelResponseBuilder withDate(LocalDate date) {
            dto.date = date;
            return this;
        }

        public CashRegisterTravelResponseDTO build() {
            return dto;
        }

    }

    public SimpleCarResponseDTO getCar() {
        return car;
    }

    public SimpleDriverResponseDTO getDriver() {
        return driver;
    }

    public BigDecimal getPercentualDriver() {
        return percentualDriver;
    }

    public BigDecimal getValueDriver() {
        return valueDriver;
    }

    public String getCity() {
        return city;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public BigDecimal getKm() {
        return km;
    }

    public BigDecimal getAveragePriceKm() {
        return averagePriceKm;
    }

    public LocalDate getDate() {
        return date;
    }

}

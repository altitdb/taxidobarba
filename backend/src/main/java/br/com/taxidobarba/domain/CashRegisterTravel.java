package br.com.taxidobarba.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cashRegisterTravel")
public class CashRegisterTravel {

    @Id
    private String id;
    private Car car;
    private Driver driver;
    private BigDecimal percentualDriver;
    private BigDecimal valueDriver;
    private String city;
    private BigDecimal price;
    private BigDecimal netValue;
    private BigDecimal km;
    private BigDecimal averagePriceKm;
    private LocalDate date;

    public static class CashRegisterTravelBuilder {

        private CashRegisterTravel cashRegisterTravel;

        public CashRegisterTravelBuilder() {
            cashRegisterTravel = new CashRegisterTravel();
        }

        public CashRegisterTravelBuilder withCar(Car car) {
            cashRegisterTravel.car = car;
            return this;
        }

        public CashRegisterTravelBuilder withDriver(Driver driver) {
            cashRegisterTravel.driver = driver;
            return this;
        }

        public CashRegisterTravelBuilder withPercentualDriver(BigDecimal percentualDriver) {
            cashRegisterTravel.percentualDriver = percentualDriver;
            return this;
        }

        public CashRegisterTravelBuilder withValueDriver(BigDecimal valueDriver) {
            cashRegisterTravel.valueDriver = valueDriver;
            return this;
        }

        public CashRegisterTravelBuilder withCity(String city) {
            cashRegisterTravel.city = city;
            return this;
        }

        public CashRegisterTravelBuilder withPrice(BigDecimal price) {
            cashRegisterTravel.price = price;
            return this;
        }

        public CashRegisterTravelBuilder withNetValue(BigDecimal netValue) {
            cashRegisterTravel.netValue = netValue;
            return this;
        }

        public CashRegisterTravelBuilder withKm(BigDecimal km) {
            cashRegisterTravel.km = km;
            return this;
        }

        public CashRegisterTravelBuilder withAveragePriceKm(BigDecimal averagePriceKm) {
            cashRegisterTravel.averagePriceKm = averagePriceKm;
            return this;
        }

        public CashRegisterTravelBuilder withDate(LocalDate date) {
            cashRegisterTravel.date = date;
            return this;
        }

        public CashRegisterTravel build() {
            return cashRegisterTravel;
        }
    }

    public String getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public Driver getDriver() {
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

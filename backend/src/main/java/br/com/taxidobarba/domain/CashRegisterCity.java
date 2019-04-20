package br.com.taxidobarba.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cashRegisterCity")
public class CashRegisterCity {

    @Id
    private String id;
    private Car car;
    private Driver driver;
    private BigDecimal priceKmDriver;
    private BigDecimal km;
    private BigDecimal price;
    private BigDecimal totalReceived;
    private BigDecimal difference;
    private LocalDate date;
    private BigDecimal startKm;
    private BigDecimal endKm;
    private BigDecimal otherKm;

    public static class CashRegisterCityBuilder {

        private CashRegisterCity cashRegisterCity;

        public CashRegisterCityBuilder() {
            cashRegisterCity = new CashRegisterCity();
        }

        public CashRegisterCityBuilder withCar(Car car) {
            cashRegisterCity.car = car;
            return this;
        }

        public CashRegisterCityBuilder withDriver(Driver driver) {
            cashRegisterCity.driver = driver;
            return this;
        }

        public CashRegisterCityBuilder withPriceKmDriver(BigDecimal priceKmDriver) {
            cashRegisterCity.priceKmDriver = priceKmDriver;
            return this;
        }

        public CashRegisterCityBuilder withKm(BigDecimal km) {
            cashRegisterCity.km = km;
            return this;
        }

        public CashRegisterCityBuilder withPrice(BigDecimal price) {
            cashRegisterCity.price = price;
            return this;
        }

        public CashRegisterCityBuilder withTotalReceived(BigDecimal totalReceived) {
            cashRegisterCity.totalReceived = totalReceived;
            return this;
        }

        public CashRegisterCityBuilder withDifference(BigDecimal difference) {
            cashRegisterCity.difference = difference;
            return this;
        }

        public CashRegisterCityBuilder withDate(LocalDate date) {
            cashRegisterCity.date = date;
            return this;
        }

        public CashRegisterCityBuilder withStartKm(BigDecimal startKm) {
            cashRegisterCity.startKm = startKm;
            return this;
        }

        public CashRegisterCityBuilder withEndKm(BigDecimal endKm) {
            cashRegisterCity.endKm = endKm;
            return this;
        }

        public CashRegisterCityBuilder withOtherKm(BigDecimal otherKm) {
            cashRegisterCity.otherKm = otherKm;
            return this;
        }

        public CashRegisterCityBuilder forUpdate(CashRegisterCity cashRegisterCity) {
            this.cashRegisterCity = cashRegisterCity;
            return this;
        }

        public CashRegisterCity build() {
            return cashRegisterCity;
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

package br.com.taxidobarba.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fuel")
public class Fuel {

    @Id
    private String id;
    private BigDecimal km;
    private BigDecimal liters;
    private BigDecimal price;
    private BigDecimal fuelPrice;
    private LocalDate date;
    private Car car;
    private Driver driver;

    public static class FuelBuilder {

        private Fuel fuel;

        public FuelBuilder() {
            fuel = new Fuel();
        }

        public FuelBuilder withKm(BigDecimal km) {
            fuel.km = km;
            return this;
        }

        public FuelBuilder withLiters(BigDecimal liters) {
            fuel.liters = liters;
            return this;
        }

        public FuelBuilder withPrice(BigDecimal price) {
            fuel.price = price;
            return this;
        }

        public FuelBuilder withFuelPrice(BigDecimal fuelPrice) {
            fuel.fuelPrice = fuelPrice;
            return this;
        }

        public FuelBuilder withDate(LocalDate date) {
            fuel.date = date;
            return this;
        }

        public FuelBuilder wihtCar(Car car) {
            fuel.car = car;
            return this;
        }

        public FuelBuilder withDriver(Driver driver) {
            fuel.driver = driver;
            return this;
        }

        public Fuel build() {
            return fuel;
        }

    }

    public String getId() {
        return id;
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

    public Car getCar() {
        return car;
    }

    public Driver getDriver() {
        return driver;
    }

}

package br.com.taxidobarba.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "car")
public class Car {

    @Id
    private String id;
    private String name;
    private String licensePlate;

    public static class CarBuilder {

        private Car car;

        public CarBuilder() {
            car = new Car();
        }

        public CarBuilder withName(String name) {
            car.name = name;
            return this;
        }

        public CarBuilder withLicensePlate(String licensePlate) {
            car.licensePlate = licensePlate;
            return this;
        }

        public Car build() {
            return car;
        }

    }

    public String getName() {
        return name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getId() {
        return id;
    }

}

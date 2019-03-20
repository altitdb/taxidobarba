package br.com.taxidobarba.mock;

import br.com.taxidobarba.domain.Car;

public class CarMock {

    public static Car mockCar() {
        Car car = new Car();
        car.setLicensePlate("ASDF");
        car.setName("Corsa");
        return car;
    }

}

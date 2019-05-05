package br.com.taxidobarba.domain.response.dto;

import br.com.taxidobarba.domain.Car;

public class SimpleCarResponseDTO {

    private String id;
    private String name;

    public SimpleCarResponseDTO(Car car) {
        this.id = car.getId();
        this.name = car.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

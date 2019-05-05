package br.com.taxidobarba.domain.request.dto;

import javax.validation.constraints.NotNull;

public class CarRequestDTO {

    @NotNull
    private String name;
    @NotNull
    private String licensePlate;

    public String getName() {
        return name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "CarRequestDTO [name=" + name + ", licensePlate=" + licensePlate + "]";
    }

}

package br.com.taxidobarba.domain.dto;

import br.com.taxidobarba.domain.Driver;

public class SimpleDriverResponseDTO {

    private String id;
    private String name;

    public SimpleDriverResponseDTO(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

package br.com.taxidobarba.mock;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;

import br.com.taxidobarba.domain.dto.CarRequestDTO;

public class CarRequestDTOMock {

    public static CarRequestDTO mockCarRequestDTO() {
        CarRequestDTO carRequestDTO = new CarRequestDTO();

        Field name = ReflectionUtils.findField(CarRequestDTO.class, "name");
        Field licensePlate = ReflectionUtils.findField(CarRequestDTO.class, "licensePlate");

        ReflectionUtils.makeAccessible(name);
        ReflectionUtils.makeAccessible(licensePlate);

        ReflectionUtils.setField(name, carRequestDTO, "Gol");
        ReflectionUtils.setField(licensePlate, carRequestDTO, "77683955060");

        return carRequestDTO;
    }

}

package br.com.taxidobarba.mock;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.util.ReflectionUtils;

import br.com.taxidobarba.domain.dto.CashRegisterTravelRequestDTO;

public class CashRegisterTravelRequestDTOMock {

    public static CashRegisterTravelRequestDTO mockCashRegisterTravelRequestDTO() {

        CashRegisterTravelRequestDTO cashRegisterTravelRequestDto = new CashRegisterTravelRequestDTO();

        Field carId = ReflectionUtils.findField(CashRegisterTravelRequestDTO.class, "carId");
        Field driverId = ReflectionUtils.findField(CashRegisterTravelRequestDTO.class, "driverId");
        Field percentualDriver = ReflectionUtils.findField(CashRegisterTravelRequestDTO.class, "percentualDriver");
        Field city = ReflectionUtils.findField(CashRegisterTravelRequestDTO.class, "city");
        Field price = ReflectionUtils.findField(CashRegisterTravelRequestDTO.class, "price");
        Field km = ReflectionUtils.findField(CashRegisterTravelRequestDTO.class, "km");
        Field date = ReflectionUtils.findField(CashRegisterTravelRequestDTO.class, "date");

        ReflectionUtils.makeAccessible(carId);
        ReflectionUtils.makeAccessible(driverId);
        ReflectionUtils.makeAccessible(percentualDriver);
        ReflectionUtils.makeAccessible(city);
        ReflectionUtils.makeAccessible(price);
        ReflectionUtils.makeAccessible(km);
        ReflectionUtils.makeAccessible(date);

        ReflectionUtils.setField(carId, cashRegisterTravelRequestDto, "asct9547dg41");
        ReflectionUtils.setField(driverId, cashRegisterTravelRequestDto, "Werbn980023lo");
        ReflectionUtils.setField(percentualDriver, cashRegisterTravelRequestDto, BigDecimal.TEN);
        ReflectionUtils.setField(city, cashRegisterTravelRequestDto, "Londrina");
        ReflectionUtils.setField(price, cashRegisterTravelRequestDto, new BigDecimal(25));
        ReflectionUtils.setField(km, cashRegisterTravelRequestDto, new BigDecimal(158.6));
        ReflectionUtils.setField(date, cashRegisterTravelRequestDto, LocalDate.now());

        return cashRegisterTravelRequestDto;
    }

}

package br.com.taxidobarba.mock;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.util.ReflectionUtils;

import br.com.taxidobarba.domain.dto.DriverRequestDTO;

public class DriverResquestDTOMock {

	public static DriverRequestDTO mockDriverRequestDTO() {

		DriverRequestDTO driverRequestDto = new DriverRequestDTO();

		Field name = ReflectionUtils.findField(DriverRequestDTO.class, "name");
		Field taxIdentifier = ReflectionUtils.findField(DriverRequestDTO.class, "taxIdentifier");
		Field nationalRegister = ReflectionUtils.findField(DriverRequestDTO.class, "nationalRegister");
		Field birthDate = ReflectionUtils.findField(DriverRequestDTO.class, "birthDate");
		Field licenseNumber = ReflectionUtils.findField(DriverRequestDTO.class, "licenseNumber");
		Field priceKm = ReflectionUtils.findField(DriverRequestDTO.class, "priceKm");
		Field percentualTravel = ReflectionUtils.findField(DriverRequestDTO.class, "percentualTravel");
		Field licenseDueDate = ReflectionUtils.findField(DriverRequestDTO.class, "licenseDueDate");
		Field enable = ReflectionUtils.findField(DriverRequestDTO.class, "enable");

		ReflectionUtils.makeAccessible(name);
		ReflectionUtils.makeAccessible(taxIdentifier);
		ReflectionUtils.makeAccessible(nationalRegister);
		ReflectionUtils.makeAccessible(birthDate);
		ReflectionUtils.makeAccessible(licenseDueDate);
		ReflectionUtils.makeAccessible(licenseNumber);
		ReflectionUtils.makeAccessible(priceKm);
		ReflectionUtils.makeAccessible(percentualTravel);
		ReflectionUtils.makeAccessible(enable);

		ReflectionUtils.setField(name, driverRequestDto, "Taxista A");
		ReflectionUtils.setField(taxIdentifier, driverRequestDto, "77683955060");
		ReflectionUtils.setField(nationalRegister, driverRequestDto, "123456");
		ReflectionUtils.setField(birthDate, driverRequestDto, LocalDate.of(1980, 01, 20));
		ReflectionUtils.setField(licenseDueDate, driverRequestDto, LocalDate.of(2022, 01, 20));
		ReflectionUtils.setField(licenseNumber, driverRequestDto, "456789");
		ReflectionUtils.setField(priceKm, driverRequestDto, BigDecimal.TEN);
		ReflectionUtils.setField(percentualTravel, driverRequestDto, BigDecimal.ONE);
		ReflectionUtils.setField(enable, driverRequestDto, Boolean.TRUE);

		return driverRequestDto;
	}
}

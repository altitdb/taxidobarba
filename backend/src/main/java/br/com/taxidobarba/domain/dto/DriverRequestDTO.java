package br.com.taxidobarba.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DriverRequestDTO {

	@NotEmpty
	private String name;
	@NotEmpty
	private String taxIdentifier;
	@NotEmpty
	private String nationalRegister;
	@NotNull
	private LocalDate birthDate;
	@NotEmpty
	private String licenseNumber;
	@NotNull
	private LocalDate licenseDueDate;
	@NotNull
	private BigDecimal priceKm;
	@NotNull
	private Boolean enable;

	public String getName() {
		return name;
	}

	public String getTaxIdentifier() {
		return taxIdentifier;
	}

	public String getNationalRegister() {
		return nationalRegister;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public LocalDate getLicenseDueDate() {
		return licenseDueDate;
	}

	public BigDecimal getPriceKm() {
		return priceKm;
	}

	public Boolean isEnable() {
		return enable;
	}

}

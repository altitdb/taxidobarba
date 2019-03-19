package br.com.taxidobarba.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

public class DriverRequestDTO {

	@NotEmpty
	private String name;
	@NotEmpty
	@CPF(message = "CPF invalido")
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
	private BigDecimal percentualTravel;
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

	public BigDecimal getPercentualTravel() {
		return percentualTravel;
	}

	public Boolean isEnable() {
		return enable;
	}

}

package br.com.taxidobarba.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DriverResponseDTO {

	private String id;
	private String name;
	private String taxIdentifier;
	private String nationalRegister;
	private LocalDate birthDate;
	private String licenseNumber;
	private LocalDate licenseDueDate;
	private BigDecimal priceKm;
	private BigDecimal percentualTravel;
	private Boolean enable;

	public static class DriverResponseBuilder {

		private DriverResponseDTO dto;

		public DriverResponseBuilder() {
			this.dto = new DriverResponseDTO();
		}

		public DriverResponseBuilder withId(String id) {
			dto.id = id;
			return this;
		}

		public DriverResponseBuilder withName(String name) {
			dto.name = name;
			return this;
		}

		public DriverResponseBuilder withTaxIdentifier(String taxIdentifier) {
			dto.taxIdentifier = taxIdentifier;
			return this;
		}

		public DriverResponseBuilder withNationalRegister(String nationalRegister) {
			dto.nationalRegister = nationalRegister;
			return this;
		}

		public DriverResponseBuilder withBirthDate(LocalDate birthDate) {
			dto.birthDate = birthDate;
			return this;
		}

		public DriverResponseBuilder withLicenseNumber(String licenseNumber) {
			dto.licenseNumber = licenseNumber;
			return this;
		}

		public DriverResponseBuilder withLicenseDueDate(LocalDate licenseDueDate) {
			dto.licenseDueDate = licenseDueDate;
			return this;
		}

		public DriverResponseBuilder withPriceKm(BigDecimal priceKm) {
			dto.priceKm = priceKm;
			return this;
		}

		public DriverResponseBuilder withPercentualTravel(BigDecimal percentualTravel) {
			dto.percentualTravel = percentualTravel;
			return this;
		}

		public DriverResponseBuilder isEnable(Boolean enable) {
			dto.enable = enable;
			return this;
		}

		public DriverResponseDTO build() {
			return dto;
		}
	}

	public String getId() {
		return id;
	}

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

	public Boolean getEnable() {
		return enable;
	}

}

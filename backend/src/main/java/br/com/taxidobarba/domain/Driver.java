package br.com.taxidobarba.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "driver")
public class Driver {

	@Id
	private String id;
	private String name;
	private String taxIdentifier;
	private String nationalRegister;
	private LocalDate birthDate;
	private String licenseNumber;
	private LocalDate licenseDueDate;
	private BigDecimal priceKm;
	private Boolean enable;

	public static class DriverBuilder {

		private Driver driver;

		public DriverBuilder() {
			this.driver = new Driver();
		}

		public DriverBuilder withName(String name) {
			driver.name = name;
			return this;
		}

		public DriverBuilder withTaxIdentifier(String taxIdentifier) {
			driver.taxIdentifier = taxIdentifier;
			return this;
		}

		public DriverBuilder withNationalRegister(String nationalRegister) {
			driver.nationalRegister = nationalRegister;
			return this;
		}

		public DriverBuilder withBirthDate(LocalDate birthDate) {
			driver.birthDate = birthDate;
			return this;
		}

		public DriverBuilder withLicenseNumber(String licenseNumber) {
			driver.licenseNumber = licenseNumber;
			return this;
		}

		public DriverBuilder withLicenseDueDate(LocalDate licenseDueDate) {
			driver.licenseDueDate = licenseDueDate;
			return this;
		}

		public DriverBuilder withPriceKm(BigDecimal priceKm) {
			driver.priceKm = priceKm;
			return this;
		}

		public DriverBuilder isEnable(Boolean enable) {
			driver.enable = enable;
			return this;
		}

		public Driver build() {
			return driver;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxIdentifier() {
		return taxIdentifier;
	}

	public void setTaxIdentifier(String taxIdentifier) {
		this.taxIdentifier = taxIdentifier;
	}

	public String getNationalRegister() {
		return nationalRegister;
	}

	public void setNationalRegister(String nationalRegister) {
		this.nationalRegister = nationalRegister;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public LocalDate getLicenseDueDate() {
		return licenseDueDate;
	}

	public void setLicenseDueDate(LocalDate licenseDueDate) {
		this.licenseDueDate = licenseDueDate;
	}

	public BigDecimal getPriceKm() {
		return priceKm;
	}

	public void setPriceKm(BigDecimal priceKm) {
		this.priceKm = priceKm;
	}

	public Boolean isEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", taxIdentifier=" + taxIdentifier + ", nationalRegister="
				+ nationalRegister + ", birthDate=" + birthDate + ", licenseNumber=" + licenseNumber
				+ ", licenseDueDate=" + licenseDueDate + ", priceKm=" + priceKm + ", enable=" + enable + "]";
	}

}

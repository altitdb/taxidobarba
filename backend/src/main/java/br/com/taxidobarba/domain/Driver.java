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
	private LocalDate bithDate;
	private String licenseNumber;
	private LocalDate licenseDueDate;
	private BigDecimal priceKm;
	private Boolean enable;

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

	public LocalDate getBithDate() {
		return bithDate;
	}

	public void setBithDate(LocalDate bithDate) {
		this.bithDate = bithDate;
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

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getId() {
		return id;
	}

}

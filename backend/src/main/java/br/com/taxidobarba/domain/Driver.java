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
    private BigDecimal percentualTravel;
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

        public DriverBuilder withPercentualTravel(BigDecimal percentualTravel) {
            driver.percentualTravel = percentualTravel;
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

    public Boolean isEnable() {
        return enable;
    }

    @Override
    public String toString() {
        return "Driver [id=" + id + ", name=" + name + ", taxIdentifier=" + taxIdentifier + ", nationalRegister="
                + nationalRegister + ", birthDate=" + birthDate + ", licenseNumber=" + licenseNumber
                + ", licenseDueDate=" + licenseDueDate + ", priceKm=" + priceKm + ", enable=" + enable + "]";
    }

}

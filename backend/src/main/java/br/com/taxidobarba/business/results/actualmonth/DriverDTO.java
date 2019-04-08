package br.com.taxidobarba.business.results.actualmonth;

import java.math.BigDecimal;

public class DriverDTO {

    private String name;
    private BigDecimal amount;
    private BigDecimal percentage;
    private BigDecimal average;

    public static class DriverBuilder {

        private DriverDTO dto;

        public DriverBuilder() {
            dto = new DriverDTO();
        }

        public DriverBuilder withName(String name) {
            dto.name = name;
            return this;
        }

        public DriverBuilder withAmount(BigDecimal amount) {
            dto.amount = amount;
            return this;
        }

        public DriverBuilder withPercentage(BigDecimal percentage) {
            dto.percentage = percentage;
            return this;
        }

        public DriverBuilder withAverage(BigDecimal average) {
            dto.average = average;
            return this;
        }

        public DriverDTO build() {
            return dto;
        }
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public BigDecimal getAverage() {
        return average;
    }

}

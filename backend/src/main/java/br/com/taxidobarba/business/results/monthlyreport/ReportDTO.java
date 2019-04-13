package br.com.taxidobarba.business.results.monthlyreport;

import java.math.BigDecimal;

public class ReportDTO {

    private String date;
    private BigDecimal value;
    private BigDecimal km;
    private CashRegisterType type;
    private String driver;

    public static class ReportBuilder {

        private ReportDTO dto;

        public ReportBuilder() {
            dto = new ReportDTO();
        }

        public ReportBuilder withDate(String date) {
            dto.date = date;
            return this;
        }

        public ReportBuilder withValue(BigDecimal value) {
            dto.value = value;
            return this;
        }

        public ReportBuilder withKm(BigDecimal km) {
            dto.km = km;
            return this;
        }

        public ReportBuilder withType(CashRegisterType type) {
            dto.type = type;
            return this;
        }

        public ReportBuilder withDriver(String driver) {
            dto.driver = driver;
            return this;
        }

        public ReportDTO build() {
            return dto;
        }
    }

    public String getDate() {
        return date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getKm() {
        return km;
    }

    public CashRegisterType getType() {
        return type;
    }

    public String getDriver() {
        return driver;
    }

}

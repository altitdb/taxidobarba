package br.com.taxidobarba.business.results.annualsummary;

import java.math.BigDecimal;

public class SummaryDTO {

    private String month;
    private BigDecimal grossValue;
    private BigDecimal netValue;

    public static class SummaryBuilder {

        private SummaryDTO dto;

        public SummaryBuilder() {
            dto = new SummaryDTO();
        }

        public SummaryBuilder withMonth(String month) {
            dto.month = month;
            return this;
        }

        public SummaryBuilder withGrossValue(BigDecimal grossValue) {
            dto.grossValue = grossValue;
            return this;
        }

        public SummaryBuilder withNetValue(BigDecimal netValue) {
            dto.netValue = netValue;
            return this;
        }

        public SummaryDTO build() {
            return dto;
        }

    }

    public String getMonth() {
        return month;
    }

    public BigDecimal getGrossValue() {
        return grossValue;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

}

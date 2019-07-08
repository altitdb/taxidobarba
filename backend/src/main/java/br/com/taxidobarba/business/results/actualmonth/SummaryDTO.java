package br.com.taxidobarba.business.results.actualmonth;

import java.math.BigDecimal;

public class SummaryDTO {

    private BigDecimal netValue;
    private BigDecimal grossValue;
    private BigDecimal averageDayValue;

    public static class SummaryBuilder {

        private SummaryDTO dto;

        public SummaryBuilder() {
            dto = new SummaryDTO();
        }

        public SummaryBuilder withNetValue(BigDecimal netValue) {
            dto.netValue = netValue;
            return this;
        }

        public SummaryBuilder withGrossValue(BigDecimal grossValue) {
            dto.grossValue = grossValue;
            return this;
        }

        public SummaryBuilder withAverageDayValue(BigDecimal averageDayValue) {
            dto.averageDayValue = averageDayValue;
            return this;
        }

        public SummaryDTO build() {
            return dto;
        }
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public BigDecimal getGrossValue() {
        return grossValue;
    }

    public BigDecimal getAverageDayValue() {
        return averageDayValue;
    }

}

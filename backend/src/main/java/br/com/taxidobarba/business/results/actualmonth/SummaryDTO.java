package br.com.taxidobarba.business.results.actualmonth;

import java.math.BigDecimal;

public class SummaryDTO {

    private BigDecimal netValue;
    private BigDecimal grossValue;
    private BigDecimal expectedValue;

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

        public SummaryBuilder withExpectedValue(BigDecimal expectedValue) {
            dto.expectedValue = expectedValue;
            return this;
        }

        public SummaryDTO build() {
            return dto;
        }
    }
}

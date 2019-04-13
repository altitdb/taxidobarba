package br.com.taxidobarba.business.results.annualsummary;

import java.math.BigDecimal;

public class AmountDTO {

    private BigDecimal grossValue;
    private BigDecimal netValue;

    public static class AmountBuilder {

        private AmountDTO dto;

        public AmountBuilder() {
            dto = new AmountDTO();
        }

        public AmountBuilder withGrossValue(BigDecimal grossValue) {
            dto.grossValue = grossValue;
            return this;
        }

        public AmountBuilder withNetValue(BigDecimal netValue) {
            dto.netValue = netValue;
            return this;
        }

        public AmountDTO build() {
            return dto;
        }

    }

    public BigDecimal getGrossValue() {
        return grossValue;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

}

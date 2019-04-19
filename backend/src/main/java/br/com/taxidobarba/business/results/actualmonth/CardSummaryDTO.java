package br.com.taxidobarba.business.results.actualmonth;

import java.math.BigDecimal;

public class CardSummaryDTO {

    private BigDecimal netValue;
    private BigDecimal taxValue;
    private BigDecimal percent;

    public static class CardSummaryBuilder {

        private CardSummaryDTO dto;

        public CardSummaryBuilder() {
            dto = new CardSummaryDTO();
        }

        public CardSummaryBuilder withNetValue(BigDecimal netValue) {
            dto.netValue = netValue;
            return this;
        }

        public CardSummaryBuilder withTaxValue(BigDecimal taxValue) {
            dto.taxValue = taxValue;
            return this;
        }

        public CardSummaryBuilder withPercent(BigDecimal percent) {
            dto.percent = percent;
            return this;
        }

        public CardSummaryDTO build() {
            return dto;
        }
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public BigDecimal getTaxValue() {
        return taxValue;
    }

    public BigDecimal getPercent() {
        return percent;
    }

}

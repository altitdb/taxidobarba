package br.com.taxidobarba.business.results.actualmonth;

import java.math.BigDecimal;

public class CardDebitDTO {

    private BigDecimal grossValue;
    private BigDecimal taxValue;
    private BigDecimal netValue;
    
    public static class CardDebitBuilder {

        private CardDebitDTO dto;

        public CardDebitBuilder() {
            dto = new CardDebitDTO();
        }

        public CardDebitBuilder withGrossValue(BigDecimal grossValue) {
            dto.grossValue = grossValue;
            return this;
        }

        public CardDebitBuilder withTaxValue(BigDecimal taxValue) {
            dto.taxValue = taxValue;
            return this;
        }

        public CardDebitBuilder withNetValue(BigDecimal netValue) {
            dto.netValue = netValue;
            return this;
        }

        public CardDebitDTO build() {
            return dto;
        }
    }
}

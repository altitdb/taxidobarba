package br.com.taxidobarba.business.results.actualmonth;

import java.math.BigDecimal;

public class CardCreditDTO {

    private BigDecimal grossValue;
    private BigDecimal taxValue;
    private BigDecimal netValue;

    public static class CardCreditBuilder {

        private CardCreditDTO dto;

        public CardCreditBuilder() {
            dto = new CardCreditDTO();
        }

        public CardCreditBuilder withGrossValue(BigDecimal grossValue) {
            dto.grossValue = grossValue;
            return this;
        }

        public CardCreditBuilder withTaxValue(BigDecimal taxValue) {
            dto.taxValue = taxValue;
            return this;
        }

        public CardCreditBuilder withNetValue(BigDecimal netValue) {
            dto.netValue = netValue;
            return this;
        }

        public CardCreditDTO build() {
            return dto;
        }
    }
}

package br.com.taxidobarba.business.results.monthlyreport;

import java.math.BigDecimal;

public class AmountDTO {

    private BigDecimal amount;

    public static class AmountBuilder {

        private AmountDTO dto;

        public AmountBuilder() {
            dto = new AmountDTO();
        }

        public AmountBuilder withAmount(BigDecimal amount) {
            dto.amount = amount;
            return this;
        }

        public AmountDTO build() {
            return dto;
        }

    }

    public BigDecimal getAmount() {
        return amount;
    }

}

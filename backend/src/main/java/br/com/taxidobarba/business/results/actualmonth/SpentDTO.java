package br.com.taxidobarba.business.results.actualmonth;

import java.math.BigDecimal;

public class SpentDTO {

    private BigDecimal fuel;
    private BigDecimal others;
    private BigDecimal amount;

    public static class SpentBuilder {

        private SpentDTO dto;

        public SpentBuilder() {
            dto = new SpentDTO();
        }

        public SpentBuilder withFuel(BigDecimal fuel) {
            dto.fuel = fuel;
            return this;
        }

        public SpentBuilder withOthers(BigDecimal others) {
            dto.others = others;
            return this;
        }

        public SpentBuilder withAmount(BigDecimal amount) {
            dto.amount = amount;
            return this;
        }

        public SpentDTO build() {
            return dto;
        }
    }
}

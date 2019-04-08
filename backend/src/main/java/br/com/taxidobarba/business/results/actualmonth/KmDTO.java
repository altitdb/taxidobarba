package br.com.taxidobarba.business.results.actualmonth;

import java.math.BigDecimal;

public class KmDTO {

    private BigDecimal kmRolledCity;
    private BigDecimal kmRolledTravel;
    private BigDecimal amountKmRolled;

    public static class KmBuilder {

        private KmDTO dto;

        public KmBuilder() {
            dto = new KmDTO();
        }

        public KmBuilder withKmRolledCity(BigDecimal kmRolledCity) {
            dto.kmRolledCity = kmRolledCity;
            return this;
        }

        public KmBuilder withKmRolledTravel(BigDecimal kmRolledTravel) {
            dto.kmRolledTravel = kmRolledTravel;
            return this;
        }

        public KmBuilder withAmountKmRolled(BigDecimal amountKmRolled) {
            dto.amountKmRolled = amountKmRolled;
            return this;
        }

        public KmDTO build() {
            return dto;
        }
    }

    public BigDecimal getKmRolledCity() {
        return kmRolledCity;
    }

    public BigDecimal getKmRolledTravel() {
        return kmRolledTravel;
    }

    public BigDecimal getAmountKmRolled() {
        return amountKmRolled;
    }

}

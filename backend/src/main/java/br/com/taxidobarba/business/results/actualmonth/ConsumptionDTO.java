package br.com.taxidobarba.business.results.actualmonth;

import java.math.BigDecimal;

public class ConsumptionDTO {

    private BigDecimal litersPerKm;
    private BigDecimal averagePriceSpentPerKm;
    private BigDecimal averageKmPerDay;
    private BigDecimal averagePricePerDay;
    private BigDecimal averagePriceFuel;

    public static class ConsumptionBuilder {

        private ConsumptionDTO dto;

        public ConsumptionBuilder() {
            dto = new ConsumptionDTO();
        }

        public ConsumptionBuilder withLitersPerKm(BigDecimal litersPerKm) {
            dto.litersPerKm = litersPerKm;
            return this;
        }

        public ConsumptionBuilder withAveragePriceSpentPerKm(BigDecimal averagePriceSpentPerKm) {
            dto.averagePriceSpentPerKm = averagePriceSpentPerKm;
            return this;
        }

        public ConsumptionBuilder withAverageKmPerDay(BigDecimal averageKmPerDay) {
            dto.averageKmPerDay = averageKmPerDay;
            return this;
        }

        public ConsumptionBuilder withAveragePricePerDay(BigDecimal averagePricePerDay) {
            dto.averagePricePerDay = averagePricePerDay;
            return this;
        }

        public ConsumptionBuilder withAveragePriceFuel(BigDecimal averagePriceFuel) {
            dto.averagePriceFuel = averagePriceFuel;
            return this;
        }

        public ConsumptionDTO build() {
            return dto;
        }
    }
}

package br.com.taxidobarba.business.results.monthlygoal;

import java.math.BigDecimal;

public class SummaryDTO {

    private BigDecimal goal;
    private BigDecimal lastMonth;
    private BigDecimal actualMonth;
    private BigDecimal percentage;

    public static class SummaryBuilder {

        private SummaryDTO dto;

        public SummaryBuilder() {
            dto = new SummaryDTO();
        }

        public SummaryBuilder withGoal(BigDecimal goal) {
            dto.goal = goal;
            return this;
        }

        public SummaryBuilder withLastMonth(BigDecimal lastMonth) {
            dto.lastMonth = lastMonth;
            return this;
        }

        public SummaryBuilder withActualMonth(BigDecimal actualMonth) {
            dto.actualMonth = actualMonth;
            return this;
        }

        public SummaryBuilder withPercentage(BigDecimal percentage) {
            dto.percentage = percentage;
            return this;
        }

        public SummaryDTO build() {
            return dto;
        }

    }

    public BigDecimal getGoal() {
        return goal;
    }

    public BigDecimal getLastMonth() {
        return lastMonth;
    }

    public BigDecimal getActualMonth() {
        return actualMonth;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

}

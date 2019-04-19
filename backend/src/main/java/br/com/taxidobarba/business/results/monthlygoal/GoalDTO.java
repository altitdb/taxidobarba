package br.com.taxidobarba.business.results.monthlygoal;

import java.math.BigDecimal;

public class GoalDTO {

    private String date;
    private BigDecimal goal;
    private BigDecimal lastMonth;
    private BigDecimal actualMonth;
    private BigDecimal percentage;

    public static class GoalBuilder {

        private GoalDTO dto;

        public GoalBuilder() {
            dto = new GoalDTO();
        }

        public GoalBuilder withDate(String date) {
            dto.date = date;
            return this;
        }

        public GoalBuilder withGoal(BigDecimal goal) {
            dto.goal = goal;
            return this;
        }

        public GoalBuilder withLastMonth(BigDecimal lastMonth) {
            dto.lastMonth = lastMonth;
            return this;
        }

        public GoalBuilder withActualMonth(BigDecimal actualMonth) {
            dto.actualMonth = actualMonth;
            return this;
        }

        public GoalBuilder withPercentage(BigDecimal percentage) {
            dto.percentage = percentage;
            return this;
        }

        public GoalDTO build() {
            return dto;
        }

    }

    public String getDate() {
        return date;
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

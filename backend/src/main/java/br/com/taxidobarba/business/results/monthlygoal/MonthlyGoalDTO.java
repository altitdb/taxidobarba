package br.com.taxidobarba.business.results.monthlygoal;

import java.util.List;

public class MonthlyGoalDTO {

    private List<GoalDTO> goal;
    private SummaryDTO summary;

    public static class MonthlyGoalBuilder {

        private MonthlyGoalDTO dto;

        public MonthlyGoalBuilder() {
            dto = new MonthlyGoalDTO();
        }

        public MonthlyGoalBuilder withGoal(List<GoalDTO> goal) {
            dto.goal = goal;
            return this;
        }

        public MonthlyGoalBuilder withSummary(SummaryDTO summary) {
            dto.summary = summary;
            return this;
        }

        public MonthlyGoalDTO build() {
            return dto;
        }

    }

    public List<GoalDTO> getGoal() {
        return goal;
    }

    public SummaryDTO getSummary() {
        return summary;
    }

}

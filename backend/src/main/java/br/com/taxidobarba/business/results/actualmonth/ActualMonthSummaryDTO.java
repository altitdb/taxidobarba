package br.com.taxidobarba.business.results.actualmonth;

import java.util.List;

public class ActualMonthSummaryDTO {

    private String date;
    private SummaryDTO summary;
    private KmDTO km;
    private ConsumptionDTO consumption;
    private CardDTO card;
    private SpentDTO spent;
    private List<DriverDTO> driver;

    public static class ActualMonthSummaryBuilder {

        private ActualMonthSummaryDTO dto;

        public ActualMonthSummaryBuilder() {
            dto = new ActualMonthSummaryDTO();
        }

        public ActualMonthSummaryBuilder withDate(String date) {
            dto.date = date;
            return this;
        }

        public ActualMonthSummaryBuilder withSummary(SummaryDTO summary) {
            dto.summary = summary;
            return this;
        }

        public ActualMonthSummaryBuilder withKm(KmDTO km) {
            dto.km = km;
            return this;
        }

        public ActualMonthSummaryBuilder withConsumption(ConsumptionDTO consumption) {
            dto.consumption = consumption;
            return this;
        }

        public ActualMonthSummaryBuilder withCard(CardDTO card) {
            dto.card = card;
            return this;
        }

        public ActualMonthSummaryBuilder withSpent(SpentDTO spent) {
            dto.spent = spent;
            return this;
        }

        public ActualMonthSummaryBuilder withDriver(List<DriverDTO> driver) {
            dto.driver = driver;
            return this;
        }

        public ActualMonthSummaryDTO build() {
            return dto;
        }
    }

    public String getDate() {
        return date;
    }

    public SummaryDTO getSummary() {
        return summary;
    }

    public KmDTO getKm() {
        return km;
    }

    public ConsumptionDTO getConsumption() {
        return consumption;
    }

    public CardDTO getCard() {
        return card;
    }

    public SpentDTO getSpent() {
        return spent;
    }

    public List<DriverDTO> getDriver() {
        return driver;
    }

}

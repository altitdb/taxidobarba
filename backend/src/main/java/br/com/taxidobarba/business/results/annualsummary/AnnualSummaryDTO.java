package br.com.taxidobarba.business.results.annualsummary;

import java.util.List;

public class AnnualSummaryDTO {

    private List<SummaryDTO> annualSummary;
    private AmountDTO amount;

    public static class AnnualSummaryBuilder {

        private AnnualSummaryDTO dto;

        public AnnualSummaryBuilder() {
            dto = new AnnualSummaryDTO();
        }

        public AnnualSummaryBuilder withAnnualSummary(List<SummaryDTO> annualSummary) {
            dto.annualSummary = annualSummary;
            return this;
        }

        public AnnualSummaryBuilder amount(AmountDTO amount) {
            dto.amount = amount;
            return this;
        }

        public AnnualSummaryDTO build() {
            return dto;
        }

    }

    public List<SummaryDTO> getAnnualSummary() {
        return annualSummary;
    }

    public AmountDTO getAmount() {
        return amount;
    }

}

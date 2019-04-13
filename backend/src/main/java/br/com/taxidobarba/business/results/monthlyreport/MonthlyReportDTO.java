package br.com.taxidobarba.business.results.monthlyreport;

import java.util.List;

public class MonthlyReportDTO {

    private List<ReportDTO> report;
    private AmountDTO amount;

    public static class MonthlyReportBuilder {

        private MonthlyReportDTO dto;

        public MonthlyReportBuilder() {
            dto = new MonthlyReportDTO();
        }

        public MonthlyReportBuilder withReport(List<ReportDTO> report) {
            dto.report = report;
            return this;
        }

        public MonthlyReportBuilder withAmount(AmountDTO amount) {
            dto.amount = amount;
            return this;
        }

        public MonthlyReportDTO build() {
            return dto;
        }

    }

    public List<ReportDTO> getReport() {
        return report;
    }

    public AmountDTO getAmount() {
        return amount;
    }

}

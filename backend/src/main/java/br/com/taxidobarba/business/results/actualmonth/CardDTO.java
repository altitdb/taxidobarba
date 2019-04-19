package br.com.taxidobarba.business.results.actualmonth;

public class CardDTO {

    private CardCreditDTO credit;
    private CardDebitDTO debit;
    private CardSummaryDTO summary;

    public static class CardBuilder {

        private CardDTO dto;

        public CardBuilder() {
            dto = new CardDTO();
        }

        public CardBuilder withCredit(CardCreditDTO credit) {
            dto.credit = credit;
            return this;
        }

        public CardBuilder withDebit(CardDebitDTO debit) {
            dto.debit = debit;
            return this;
        }

        public CardBuilder withSummary(CardSummaryDTO summary) {
            dto.summary = summary;
            return this;
        }

        public CardDTO build() {
            return dto;
        }
    }

    public CardCreditDTO getCredit() {
        return credit;
    }

    public CardDebitDTO getDebit() {
        return debit;
    }

    public CardSummaryDTO getSummary() {
        return summary;
    }

}

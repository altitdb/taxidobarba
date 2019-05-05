package br.com.taxidobarba.domain.request.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentTrafficTicketRequestDTO {

    private String trafficTicketId;
    private BigDecimal value;
    private LocalDate date;

    public String getTrafficTicketId() {
        return trafficTicketId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "PaymentTrafficTicketRequestDTO [trafficTicketId=" + trafficTicketId + ", value=" + value + ", date="
                + date + "]";
    }

}

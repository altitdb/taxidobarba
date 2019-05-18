package br.com.taxidobarba.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paymentTrafficTicket")
public class PaymentTrafficTicket {

    @Id
    private String id;
    @DBRef
    private TrafficTicket trafficTicket;
    private BigDecimal value;
    private LocalDate date;

    public static class PaymentTrafficTicketBuilder {

        private PaymentTrafficTicket payment;

        public PaymentTrafficTicketBuilder() {
            payment = new PaymentTrafficTicket();
        }

        public PaymentTrafficTicketBuilder withTrafficTicket(TrafficTicket trafficTicket) {
            payment.trafficTicket = trafficTicket;
            return this;
        }

        public PaymentTrafficTicketBuilder withValue(BigDecimal value) {
            payment.value = value;
            return this;
        }

        public PaymentTrafficTicketBuilder withDate(LocalDate date) {
            payment.date = date;
            return this;
        }

        public PaymentTrafficTicket build() {
            return payment;
        }
    }

    public String getId() {
        return id;
    }

    public TrafficTicket getTrafficTicket() {
        return trafficTicket;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

}

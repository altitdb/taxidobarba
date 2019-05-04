package br.com.taxidobarba.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trafficTicket")
public class TrafficTicket {

    @Id
    private String id;
    private Car car;
    private Driver driver;
    private BigDecimal value;
    private Integer points;
    private LocalDate dueDate;

    public static class TrafficTicketBuilder {

        private TrafficTicket ticket;

        public TrafficTicketBuilder() {
            ticket = new TrafficTicket();
        }

        public TrafficTicketBuilder withCar(Car car) {
            ticket.car = car;
            return this;
        }

        public TrafficTicketBuilder withDriver(Driver driver) {
            ticket.driver = driver;
            return this;
        }

        public TrafficTicketBuilder withValue(BigDecimal value) {
            ticket.value = value;
            return this;
        }

        public TrafficTicketBuilder withPoints(Integer points) {
            ticket.points = points;
            return this;
        }

        public TrafficTicketBuilder withDueDate(LocalDate dueDate) {
            ticket.dueDate = dueDate;
            return this;
        }

        public TrafficTicket build() {
            return ticket;
        }
    }

    public String getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public Driver getDriver() {
        return driver;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Integer getPoints() {
        return points;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

}

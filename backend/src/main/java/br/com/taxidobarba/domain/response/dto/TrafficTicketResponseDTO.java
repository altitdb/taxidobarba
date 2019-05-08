package br.com.taxidobarba.domain.response.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.taxidobarba.domain.enumerated.TrafficTicketStatus;

public class TrafficTicketResponseDTO {

    private SimpleCarResponseDTO car;
    private SimpleDriverResponseDTO driver;
    private BigDecimal value;
    private BigDecimal paidValue;
    private TrafficTicketStatus status;
    private LocalDate dueDate;

    public static class TrafficTicketResponseBuilder {

        private TrafficTicketResponseDTO dto;

        public TrafficTicketResponseBuilder() {
            dto = new TrafficTicketResponseDTO();
        }

        public TrafficTicketResponseBuilder withCar(SimpleCarResponseDTO car) {
            dto.car = car;
            return this;
        }

        public TrafficTicketResponseBuilder withDriver(SimpleDriverResponseDTO driver) {
            dto.driver = driver;
            return this;
        }

        public TrafficTicketResponseBuilder withValue(BigDecimal value) {
            dto.value = value;
            return this;
        }

        public TrafficTicketResponseBuilder withPaidValue(BigDecimal paidValue) {
            dto.paidValue = paidValue;
            return this;
        }

        public TrafficTicketResponseBuilder withStatus(TrafficTicketStatus status) {
            dto.status = status;
            return this;
        }

        public TrafficTicketResponseBuilder withDueDate(LocalDate dueDate) {
            dto.dueDate = dueDate;
            return this;
        }

        public TrafficTicketResponseDTO build() {
            return dto;
        }

    }

    public SimpleCarResponseDTO getCar() {
        return car;
    }

    public SimpleDriverResponseDTO getDriver() {
        return driver;
    }

    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getPaidValue() {
        return paidValue;
    }

    public TrafficTicketStatus getStatus() {
        return status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

}

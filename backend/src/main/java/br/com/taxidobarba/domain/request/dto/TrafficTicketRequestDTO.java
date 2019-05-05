package br.com.taxidobarba.domain.request.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TrafficTicketRequestDTO {

    @NotBlank
    private String car;
    @NotBlank
    private String driver;
    @NotNull
    private BigDecimal value;
    @NotNull
    private Integer points;
    @NotNull
    private LocalDate dueDate;

    public String getCar() {
        return car;
    }

    public String getDriver() {
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

    @Override
    public String toString() {
        return "TrafficTicketRequestDTO [car=" + car + ", driver=" + driver + ", value=" + value + ", points=" + points
                + ", dueDate=" + dueDate + "]";
    }

}

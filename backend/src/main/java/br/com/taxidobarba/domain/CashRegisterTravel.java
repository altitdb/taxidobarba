package br.com.taxidobarba.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cashRegisterTravel")
public class CashRegisterTravel {

    @Id
    private String id;
    private Car car;
    private Driver driver;
    private BigDecimal percentualDriver;
    private BigDecimal valueDriver;
    private String city;
    private BigDecimal price;
    private BigDecimal netValue;
    private BigDecimal km;
    private BigDecimal averagePriceKm;
    private LocalDate date;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public BigDecimal getPercentualDriver() {
        return percentualDriver;
    }

    public void setPercentualDriver(BigDecimal percentualDriver) {
        this.percentualDriver = percentualDriver;
    }

    public BigDecimal getValueDriver() {
        return valueDriver;
    }

    public void setValueDriver(BigDecimal valueDriver) {
        this.valueDriver = valueDriver;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public BigDecimal getKm() {
        return km;
    }

    public void setKm(BigDecimal km) {
        this.km = km;
    }

    public BigDecimal getAveragePriceKm() {
        return averagePriceKm;
    }

    public void setAveragePriceKm(BigDecimal averagePriceKm) {
        this.averagePriceKm = averagePriceKm;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

}

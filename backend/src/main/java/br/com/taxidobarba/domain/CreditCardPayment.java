package br.com.taxidobarba.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "creditCardPayment")
public class CreditCardPayment {

    @Id
    private String id;
    private String transactionId;
    private String customerName;
    private String typeCard;
    private String transactionType;
    private String paymentStatus;
    private String paymentType;
    private BigDecimal grossValue;
    private BigDecimal discountValue;
    private BigDecimal feeValue;
    private BigDecimal netValue;
    private LocalDate transactionDate;
    private LocalDate compensationDate;
    private Integer plots;
    private String userCode;
    private String saleCode;
    private String serialReader;
    private Integer receipts;
    private Integer received;
    private BigDecimal receivedValue;
    private BigDecimal priceIntermediationRate;
    private BigDecimal valueIntermediationRate;
    private BigDecimal amountTaxInstallment;
    private BigDecimal ticketPrice;

    public static class CreditCardPaymentBuilder {
        private CreditCardPayment payment;

        public CreditCardPaymentBuilder() {
            payment = new CreditCardPayment();
        }

        public CreditCardPaymentBuilder withId(String id) {
            payment.id = id;
            return this;
        }

        public CreditCardPaymentBuilder withTransactionId(String transactionId) {
            payment.transactionId = transactionId;
            return this;
        }

        public CreditCardPaymentBuilder withCustomerName(String customerName) {
            payment.customerName = customerName;
            return this;
        }

        public CreditCardPaymentBuilder withTypeCard(String typeCard) {
            payment.typeCard = typeCard;
            return this;
        }

        public CreditCardPaymentBuilder withTransactionType(String transactionType) {
            payment.transactionType = transactionType;
            return this;
        }

        public CreditCardPaymentBuilder withPaymentStatus(String paymentStatus) {
            payment.paymentStatus = paymentStatus;
            return this;
        }

        public CreditCardPaymentBuilder withPaymentType(String paymentType) {
            payment.paymentType = paymentType;
            return this;
        }

        public CreditCardPaymentBuilder withGrossValue(BigDecimal grossValue) {
            payment.grossValue = grossValue;
            return this;
        }

        public CreditCardPaymentBuilder withDiscountValue(BigDecimal discountValue) {
            payment.discountValue = discountValue;
            return this;
        }

        public CreditCardPaymentBuilder withFeeValue(BigDecimal feeValue) {
            payment.feeValue = feeValue;
            return this;
        }

        public CreditCardPaymentBuilder withNetValue(BigDecimal netValue) {
            payment.netValue = netValue;
            return this;
        }

        public CreditCardPaymentBuilder withTransactionDate(LocalDate transactionDate) {
            payment.transactionDate = transactionDate;
            return this;
        }

        public CreditCardPaymentBuilder withCompensationDate(LocalDate compensationDate) {
            payment.compensationDate = compensationDate;
            return this;
        }

        public CreditCardPaymentBuilder withPlots(Integer plots) {
            payment.plots = plots;
            return this;
        }

        public CreditCardPaymentBuilder withUserCode(String userCode) {
            payment.userCode = userCode;
            return this;
        }

        public CreditCardPaymentBuilder withSaleCode(String saleCode) {
            payment.saleCode = saleCode;
            return this;
        }

        public CreditCardPaymentBuilder withSerialReader(String serialReader) {
            payment.serialReader = serialReader;
            return this;
        }

        public CreditCardPaymentBuilder withReceipts(Integer receipts) {
            payment.receipts = receipts;
            return this;
        }

        public CreditCardPaymentBuilder withReceived(Integer received) {
            payment.received = received;
            return this;
        }

        public CreditCardPaymentBuilder withReceivedValue(BigDecimal receivedValue) {
            payment.receivedValue = receivedValue;
            return this;
        }

        public CreditCardPaymentBuilder withPriceIntermediationRate(BigDecimal priceIntermediationRate) {
            payment.priceIntermediationRate = priceIntermediationRate;
            return this;
        }

        public CreditCardPaymentBuilder withValueIntermediationRate(BigDecimal valueIntermediationRate) {
            payment.valueIntermediationRate = valueIntermediationRate;
            return this;
        }

        public CreditCardPaymentBuilder withAmountTaxInstallment(BigDecimal amountTaxInstallment) {
            payment.amountTaxInstallment = amountTaxInstallment;
            return this;
        }

        public CreditCardPaymentBuilder withTicketPrice(BigDecimal ticketPrice) {
            payment.ticketPrice = ticketPrice;
            return this;
        }

        public CreditCardPayment build() {
            return payment;
        }
    }

    public String getId() {
        return id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getTypeCard() {
        return typeCard;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public BigDecimal getGrossValue() {
        return grossValue;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public BigDecimal getFeeValue() {
        return feeValue;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public LocalDate getCompensationDate() {
        return compensationDate;
    }

    public Integer getPlots() {
        return plots;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getSaleCode() {
        return saleCode;
    }

    public String getSerialReader() {
        return serialReader;
    }

    public Integer getReceipts() {
        return receipts;
    }

    public Integer getReceived() {
        return received;
    }

    public BigDecimal getReceivedValue() {
        return receivedValue;
    }

    public BigDecimal getPriceIntermediationRate() {
        return priceIntermediationRate;
    }

    public BigDecimal getValueIntermediationRate() {
        return valueIntermediationRate;
    }

    public BigDecimal getAmountTaxInstallment() {
        return amountTaxInstallment;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreditCardPayment other = (CreditCardPayment) obj;
        if (transactionId == null) {
            if (other.transactionId != null)
                return false;
        } else if (!transactionId.equals(other.transactionId))
            return false;
        return true;
    }

}

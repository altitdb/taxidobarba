package br.com.taxidobarba.domain.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CreditCardPaymentDTO {

    @JacksonXmlProperty(localName = "Transacao_ID")
    private String transactionId;
    @JacksonXmlProperty(localName = "Cliente_Nome")
    private String customerName;
    @JacksonXmlProperty(localName = "Debito_Credito")
    private String typeCard;
    @JacksonXmlProperty(localName = "Tipo_Transacao")
    private String transactionType;
    @JacksonXmlProperty(localName = "Status")
    private String paymentStatus;
    @JacksonXmlProperty(localName = "Tipo_Pagamento")
    private String paymentType;
    @JacksonXmlProperty(localName = "Valor_Bruto")
    private String grossValue;
    @JacksonXmlProperty(localName = "Valor_Desconto")
    private String discountValue;
    @JacksonXmlProperty(localName = "Valor_Taxa")
    private String feeValue;
    @JacksonXmlProperty(localName = "Valor_Liquido")
    private String netValue;
    @JacksonXmlProperty(localName = "Data_Transacao")
    private String transactionDate;
    @JacksonXmlProperty(localName = "Data_Compensacao")
    private String compensationDate;
    @JacksonXmlProperty(localName = "Parcelas")
    private String plots;
    @JacksonXmlProperty(localName = "Codigo_Usuario")
    private String userCode;
    @JacksonXmlProperty(localName = "Codigo_Venda")
    private String saleCode;
    @JacksonXmlProperty(localName = "Serial_Leitor")
    private String serialReader;
    @JacksonXmlProperty(localName = "Recebimentos")
    private String receipts;
    @JacksonXmlProperty(localName = "Recebidos")
    private String received;
    @JacksonXmlProperty(localName = "Valor_Recebido")
    private String receivedValue;
    @JacksonXmlProperty(localName = "Valor_Tarifa_Intermediacao")
    private String priceIntermediationRate;
    @JacksonXmlProperty(localName = "Valor_Taxa_Intermediacao")
    private String valueIntermediationRate;
    @JacksonXmlProperty(localName = "Valor_Taxa_Parcelamento")
    private String amountTaxInstallment;
    @JacksonXmlProperty(localName = "Valor_Tarifa_Boleto")
    private String ticketPrice;
    @JacksonXmlProperty(localName = "Bandeira_Cartao_Credito")
    private String creditCardFlag;
    @JacksonXmlProperty(localName = "Cliente_Email")
    private String emailClient;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(String typeCard) {
        this.typeCard = typeCard;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(String grossValue) {
        this.grossValue = grossValue;
    }

    public String getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(String discountValue) {
        this.discountValue = discountValue;
    }

    public String getFeeValue() {
        return feeValue;
    }

    public void setFeeValue(String feeValue) {
        this.feeValue = feeValue;
    }

    public String getNetValue() {
        return netValue;
    }

    public void setNetValue(String netValue) {
        this.netValue = netValue;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCompensationDate() {
        return compensationDate;
    }

    public void setCompensationDate(String compensationDate) {
        this.compensationDate = compensationDate;
    }

    public String getPlots() {
        return plots;
    }

    public void setPlots(String plots) {
        this.plots = plots;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    public String getSerialReader() {
        return serialReader;
    }

    public void setSerialReader(String serialReader) {
        this.serialReader = serialReader;
    }

    public String getReceipts() {
        return receipts;
    }

    public void setReceipts(String receipts) {
        this.receipts = receipts;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getReceivedValue() {
        return receivedValue;
    }

    public void setReceivedValue(String receivedValue) {
        this.receivedValue = receivedValue;
    }

    public String getPriceIntermediationRate() {
        return priceIntermediationRate;
    }

    public void setPriceIntermediationRate(String priceIntermediationRate) {
        this.priceIntermediationRate = priceIntermediationRate;
    }

    public String getValueIntermediationRate() {
        return valueIntermediationRate;
    }

    public void setValueIntermediationRate(String valueIntermediationRate) {
        this.valueIntermediationRate = valueIntermediationRate;
    }

    public String getAmountTaxInstallment() {
        return amountTaxInstallment;
    }

    public void setAmountTaxInstallment(String amountTaxInstallment) {
        this.amountTaxInstallment = amountTaxInstallment;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getCreditCardFlag() {
        return creditCardFlag;
    }

    public void setCreditCardFlag(String creditCardFlag) {
        this.creditCardFlag = creditCardFlag;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

}

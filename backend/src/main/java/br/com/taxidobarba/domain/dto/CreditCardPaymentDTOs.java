package br.com.taxidobarba.domain.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CreditCardPaymentDTOs {

    @JacksonXmlProperty(localName = "Table")
    private CreditCardPaymentDTO[] cardPaymentDTOs;
    
    public CreditCardPaymentDTOs() {
        super();
    }

    public CreditCardPaymentDTO[] getCardPaymentDTOs() {
        return cardPaymentDTOs;
    }

    public void setCardPaymentDTOs(CreditCardPaymentDTO[] cardPaymentDTOs) {
        this.cardPaymentDTOs = cardPaymentDTOs;
    }

}

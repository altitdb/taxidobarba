package br.com.taxidobarba.validator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.taxidobarba.domain.PaymentTrafficTicket;
import br.com.taxidobarba.domain.TrafficTicket;
import br.com.taxidobarba.domain.request.dto.PaymentTrafficTicketRequestDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.PaymentTrafficTicketRepository;
import br.com.taxidobarba.repository.TrafficTicketRepository;

@Component
public class PaymentTrafficTicketValidator implements RequestValidator<PaymentTrafficTicketRequestDTO> {

    private static final Logger LOG = LogManager.getLogger(PaymentTrafficTicketValidator.class);
    
    @Autowired
    private TrafficTicketRepository trafficTicketRepository;
    @Autowired
    private PaymentTrafficTicketRepository paymentTrafficTicketRepository;
    
    @Override
    public void validateOnSave(PaymentTrafficTicketRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        
        validateDate(request.getDate());
        
        String trafficTicketId = request.getTrafficTicketId();
        TrafficTicket trafficTicket = getTrafficTicketById(trafficTicketId);
        
        validateTotalAmountPaid(trafficTicket, request.getValue());
    }

    private void validateDate(LocalDate date) {
        if (date.isAfter(LocalDate.now()))
            throw new BusinessException("Data de pagamento não pode ser maior que data atual.");
    }

    private TrafficTicket getTrafficTicketById(String trafficTicketId) {
        return trafficTicketRepository.findById(trafficTicketId)
                .orElseThrow(() -> new BusinessException("Multa não localizada pelo id: " + trafficTicketId));
    }
    
    private void validateTotalAmountPaid(TrafficTicket trafficTicket, BigDecimal paymentValue) {
        BigDecimal valueTrafficTicket = trafficTicket.getValue();
        List<PaymentTrafficTicket> payments = paymentTrafficTicketRepository.findByTrafficTicket(trafficTicket);
        
        BigDecimal amountPaid = payments.stream()
                                        .map(PaymentTrafficTicket::getValue)
                                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        if (valueTrafficTicket.compareTo(amountPaid.add(paymentValue)) < 0) {
            StringBuilder builder = new StringBuilder();
            builder.append("Valor do pagamento ultrapassa o valor total da multa.");
            builder.append(" Valor da multa: ");
            builder.append(valueTrafficTicket);
            builder.append(". ");
            builder.append("Valor já pago: ");
            builder.append(amountPaid);
            builder.append(". ");
            builder.append("Valor informado no pagamento: ");
            builder.append(paymentValue);
            throw new BusinessException(String.valueOf(builder));
        }
        
    }
}

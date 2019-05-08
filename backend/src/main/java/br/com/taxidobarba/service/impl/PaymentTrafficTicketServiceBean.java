package br.com.taxidobarba.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.PaymentTrafficTicket;
import br.com.taxidobarba.domain.TrafficTicket;
import br.com.taxidobarba.domain.request.dto.PaymentTrafficTicketRequestDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.PaymentTrafficTicketRepository;
import br.com.taxidobarba.repository.TrafficTicketRepository;
import br.com.taxidobarba.service.spec.PaymentTrafficTicketService;

@Service
public class PaymentTrafficTicketServiceBean implements PaymentTrafficTicketService{

    private static final Logger LOG = LogManager.getLogger(PaymentTrafficTicketServiceBean.class);
    
    @Autowired
    private TrafficTicketRepository trafficTicketRepository;
    @Autowired
    private PaymentTrafficTicketRepository paymentTrafficTicketRepository;
    
    @Override
    public void save(PaymentTrafficTicketRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        
        LOG.info("Iniciando validação do request...");
        validateRequest(request);
        LOG.info("Request validado.");
        
        LOG.info("Persistindo pagamento...");
        paymentTrafficTicketRepository.save(requestToEntity(request));
        LOG.info("Pagamento persistido.");
    }

    private void validateRequest(PaymentTrafficTicketRequestDTO request) {
        String trafficTicketId = request.getTrafficTicketId();
        validateDate(request.getDate());
        TrafficTicket trafficTicket = validateTrafficTicketId(trafficTicketId);
        validateTotalAmountPaid(trafficTicket, request.getValue());
    }

    private TrafficTicket validateTrafficTicketId(String trafficTicketId) {
        return getTrafficTicketById(trafficTicketId);
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

    
    
    private void validateDate(LocalDate date) {
        if(date.isAfter(LocalDate.now()))
            throw new BusinessException("Data de pagamento não pode ser maior que data atual.");
    }
    
    private PaymentTrafficTicket requestToEntity(PaymentTrafficTicketRequestDTO request) {
        return new PaymentTrafficTicket.PaymentTrafficTicketBuilder()
                .withDate(request.getDate())
                .withTrafficTicket(getTrafficTicketById(request.getTrafficTicketId()))
                .withValue(request.getValue())
                .build();
    }

}

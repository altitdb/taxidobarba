package br.com.taxidobarba.service;

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
import br.com.taxidobarba.validator.RequestValidator;

@Service
public class PaymentTrafficTicketServiceBean {

    private static final Logger LOG = LogManager.getLogger(PaymentTrafficTicketServiceBean.class);
    
    @Autowired
    private TrafficTicketRepository trafficTicketRepository;
    @Autowired
    private PaymentTrafficTicketRepository paymentTrafficTicketRepository;
    @Autowired
    private RequestValidator<PaymentTrafficTicketRequestDTO> validator;
    
    public void save(PaymentTrafficTicketRequestDTO request) {
        
        validator.validateOnSave(request);
        
        LOG.debug("Persistindo pagamento...");
        paymentTrafficTicketRepository.save(requestToEntity(request));
        LOG.debug("Pagamento persistido.");
    }

    private PaymentTrafficTicket requestToEntity(PaymentTrafficTicketRequestDTO request) {
        return new PaymentTrafficTicket.PaymentTrafficTicketBuilder()
                .withDate(request.getDate())
                .withTrafficTicket(getTrafficTicketById(request.getTrafficTicketId()))
                .withValue(request.getValue())
                .build();
    }

    private TrafficTicket getTrafficTicketById(String trafficTicketId) {
        return trafficTicketRepository.findById(trafficTicketId)
                .orElseThrow(() -> new BusinessException("Multa não localizada pelo id: " + trafficTicketId));
    }
}

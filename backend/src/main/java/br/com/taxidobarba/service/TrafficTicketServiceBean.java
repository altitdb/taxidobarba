package br.com.taxidobarba.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.PaymentTrafficTicket;
import br.com.taxidobarba.domain.TrafficTicket;
import br.com.taxidobarba.domain.enumerated.TrafficTicketStatus;
import br.com.taxidobarba.domain.request.dto.TrafficTicketRequestDTO;
import br.com.taxidobarba.domain.response.dto.SimpleCarResponseDTO;
import br.com.taxidobarba.domain.response.dto.SimpleDriverResponseDTO;
import br.com.taxidobarba.domain.response.dto.TrafficTicketResponseDTO;
import br.com.taxidobarba.domain.response.dto.TrafficTicketResponseDTO.TrafficTicketResponseBuilder;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.repository.PaymentTrafficTicketRepository;
import br.com.taxidobarba.repository.TrafficTicketRepository;
import br.com.taxidobarba.validator.RequestValidator;

@Service
public class TrafficTicketServiceBean {

    private static final Logger LOG = LogManager.getLogger(TrafficTicketServiceBean.class);
    
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private TrafficTicketRepository trafficTicketRepository;
    @Autowired
    private PaymentTrafficTicketRepository paymentTrafficTicketRepository;
    @Autowired
    private RequestValidator<TrafficTicketRequestDTO> validator;

    public void save(TrafficTicketRequestDTO request) {
        
        validator.validateOnSave(request);
        
        LOG.debug("Persistindo dados...");
        trafficTicketRepository.save(requestToEntity(request));
        LOG.debug("Dados persistidos.");
    }

    public List<TrafficTicketResponseDTO> findAll(TrafficTicketStatus status) {
        List<TrafficTicket> allTrafficTickets = trafficTicketRepository.findAll();
        List<TrafficTicketResponseDTO> trafficTicketResponseDtos = entityToResponseDto(allTrafficTickets);
        
        if(status != null) {
            LOG.debug("Buscando multas pelo status {}", status);
            return trafficTicketResponseDtos.stream()
                            .filter(dto -> dto.getStatus().equals(status))
                            .collect(Collectors.toList());
        }
        
        LOG.debug("Status não informado, retornando todos os registros...");
        
        return trafficTicketResponseDtos;
    }
    
    private List<TrafficTicketResponseDTO> entityToResponseDto(List<TrafficTicket> allTrafficTickets) {
        
        List<PaymentTrafficTicket> payments = paymentTrafficTicketRepository.findAll();
        List<TrafficTicketResponseDTO> trafficTicketResponseDtos = new ArrayList<>();
        
        allTrafficTickets.stream()
                .forEach(ticket -> {
                    BigDecimal amountPaid = 
                            payments.stream()
                                .filter(payment -> payment.getTrafficTicket().getId().equals(ticket.getId()))
                                .map(PaymentTrafficTicket::getValue)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);
                    
                    TrafficTicketResponseBuilder builder = new TrafficTicketResponseBuilder();
                    
                    builder.withCar(new SimpleCarResponseDTO(ticket.getCar()))
                           .withDriver(new SimpleDriverResponseDTO(ticket.getDriver()))
                           .withValue(ticket.getValue())
                           .withPaidValue(amountPaid)
                           .withDueDate(ticket.getDueDate());
                    
                    if(amountPaid.compareTo(ticket.getValue()) == 0) {
                        builder.withStatus(TrafficTicketStatus.PAID);
                    }else {
                        builder.withStatus(TrafficTicketStatus.OPENED);
                    }
                    
                    trafficTicketResponseDtos.add(builder.build());
                    
                });
        
        trafficTicketResponseDtos.sort(Comparator.comparing(TrafficTicketResponseDTO::getDueDate)); 
        
        return trafficTicketResponseDtos;
    }

    private TrafficTicket requestToEntity(TrafficTicketRequestDTO request) {
        Car car = findCarById(request.getCar());
        Driver driver = findDriverById(request.getDriver());
        
        return new TrafficTicket.TrafficTicketBuilder()
                            .withCar(car)
                            .withDriver(driver)
                            .withDueDate(request.getDueDate())
                            .withPoints(request.getPoints())
                            .withValue(request.getValue())
                            .build();
    }

    private Car findCarById(String id) {
        LOG.debug("Buscando carro...");
        return carRepository.findById(id).orElseThrow(() -> new BusinessException("Carro nao localizado."));
    }

    private Driver findDriverById(String id) {
        LOG.debug("Buscando motorista...");
        return driverRepository.findById(id).orElseThrow(() -> new BusinessException("Motorista nao localizado."));
    }
}

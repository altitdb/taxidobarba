package br.com.taxidobarba.service;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.TrafficTicket;
import br.com.taxidobarba.domain.dto.TrafficTicketRequestDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.repository.TrafficTicketRepository;

@Service
public class TrafficTicketServiceBean implements TrafficTicketService {

    private static final Logger LOG = LogManager.getLogger(TrafficTicketServiceBean.class);
    
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private TrafficTicketRepository trafficTicketRepository;

    @Override
    public void save(TrafficTicketRequestDTO request) {
        LOG.info("Dados recebidos no request: {}", request);
        
        validateRequest(request);
        
        LOG.info("Persistindo dados...");
        trafficTicketRepository.save(requestToEntity(request));
        LOG.info("Dados persistidos.");
    }

    private void validateRequest(TrafficTicketRequestDTO request) {
        final Integer[] points = {3, 4, 5, 7};
        
        if(!Arrays.asList(points).contains(request.getPoints())) {
            throw new BusinessException("Valor inválido para pontos. Valores válidos: " + Arrays.asList(points));
        }
        
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
        LOG.info("Buscando carro...");
        return carRepository.findById(id).orElseThrow(() -> new BusinessException("Carro nao localizado."));
    }

    private Driver findDriverById(String id) {
        LOG.info("Buscando motorista...");
        return driverRepository.findById(id).orElseThrow(() -> new BusinessException("Motorista nao localizado."));
    }
}

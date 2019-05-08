package br.com.taxidobarba.service.spec;

import java.util.List;

import br.com.taxidobarba.domain.enumerated.TrafficTicketStatus;
import br.com.taxidobarba.domain.request.dto.TrafficTicketRequestDTO;
import br.com.taxidobarba.domain.response.dto.TrafficTicketResponseDTO;

public interface TrafficTicketService {

    public void save(TrafficTicketRequestDTO request);
    
    public List<TrafficTicketResponseDTO> findAll(TrafficTicketStatus status);
    
}

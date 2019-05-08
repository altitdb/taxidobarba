package br.com.taxidobarba.service.spec;

import java.util.List;

import br.com.taxidobarba.domain.request.dto.CarRequestDTO;
import br.com.taxidobarba.domain.response.dto.CarResponseDTO;

public interface CarService {

    public void save(CarRequestDTO request);
    
    public List<CarResponseDTO> findAll();
        
}

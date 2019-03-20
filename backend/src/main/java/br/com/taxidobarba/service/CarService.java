package br.com.taxidobarba.service;

import java.util.List;

import br.com.taxidobarba.domain.dto.CarRequestDTO;
import br.com.taxidobarba.domain.dto.CarResponseDTO;

public interface CarService {

    public void save(CarRequestDTO request);
    
    public List<CarResponseDTO> findAll();
        
}

package br.com.taxidobarba.service;

import br.com.taxidobarba.domain.dto.FuelRequestDTO;
import br.com.taxidobarba.domain.dto.FuelResponseDTO;

public interface FuelService {

    public FuelResponseDTO save(FuelRequestDTO request);
    
}

package br.com.taxidobarba.service.spec;

import br.com.taxidobarba.domain.request.dto.FuelRequestDTO;
import br.com.taxidobarba.domain.response.dto.FuelResponseDTO;

public interface FuelService {

    public FuelResponseDTO save(FuelRequestDTO request);
    
}

package br.com.taxidobarba.service;

import br.com.taxidobarba.domain.dto.CashRegisterTravelRequestDTO;
import br.com.taxidobarba.domain.dto.CashRegisterTravelResponseDTO;

public interface CashRegisterTravelService {

    public CashRegisterTravelResponseDTO save(CashRegisterTravelRequestDTO request);

}

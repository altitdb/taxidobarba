package br.com.taxidobarba.service.spec;

import br.com.taxidobarba.domain.request.dto.CashRegisterTravelRequestDTO;
import br.com.taxidobarba.domain.response.dto.CashRegisterTravelResponseDTO;

public interface CashRegisterTravelService {

    public CashRegisterTravelResponseDTO save(CashRegisterTravelRequestDTO request);

    public CashRegisterTravelResponseDTO update(String id, CashRegisterTravelRequestDTO request);

    public CashRegisterTravelResponseDTO find(String id);

}

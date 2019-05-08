package br.com.taxidobarba.service.spec;

import br.com.taxidobarba.domain.request.dto.CashRegisterCityRequestDTO;
import br.com.taxidobarba.domain.response.dto.CashRegisterCityResponseDTO;

public interface CashRegisterCityService {

    public CashRegisterCityResponseDTO save(CashRegisterCityRequestDTO request);

    public CashRegisterCityResponseDTO update(String id, CashRegisterCityRequestDTO request);

}

package br.com.taxidobarba.service;

import br.com.taxidobarba.domain.dto.CashRegisterCityRequestDTO;
import br.com.taxidobarba.domain.dto.CashRegisterCityResponseDTO;

public interface CashRegisterCityService {

    public CashRegisterCityResponseDTO save(CashRegisterCityRequestDTO request);

    public CashRegisterCityResponseDTO update(String id, CashRegisterCityRequestDTO request);

}

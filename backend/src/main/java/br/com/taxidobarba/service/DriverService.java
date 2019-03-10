package br.com.taxidobarba.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.taxidobarba.domain.dto.DriverRequestDTO;
import br.com.taxidobarba.domain.dto.DriverResponseDTO;

public interface DriverService {

	public DriverResponseDTO save(DriverRequestDTO request);

	public List<DriverResponseDTO> findAll();

	public DriverResponseDTO findById(String id);

	public ResponseEntity<HttpStatus> delete(String id);

}

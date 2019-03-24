package br.com.taxidobarba.mock;

import java.util.HashMap;
import java.util.Map;

import br.com.taxidobarba.domain.dto.LoginRequestDTO;

public class LoginRequestDTOMock extends GenericRequestDTOMock {

    public static LoginRequestDTO mockLoginRequestDTO() {

        LoginRequestDTO loginRequestDto = new LoginRequestDTO();

        Map<String, Object> attributes = new HashMap<>();

        attributes.put("username", "taxidobarba");
        attributes.put("password", "taxidobarba");

        return createRequestDto(loginRequestDto, attributes);
    }
}

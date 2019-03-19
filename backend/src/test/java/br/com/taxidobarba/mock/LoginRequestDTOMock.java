package br.com.taxidobarba.mock;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;

import br.com.taxidobarba.domain.dto.LoginRequestDTO;

public class LoginRequestDTOMock {

    public static LoginRequestDTO mockLoginRequestDTO() {
        LoginRequestDTO loginRequestDto = new LoginRequestDTO();

        Field fieldUsername = ReflectionUtils.findField(LoginRequestDTO.class, "username");
        Field fieldPassword = ReflectionUtils.findField(LoginRequestDTO.class, "password");

        ReflectionUtils.makeAccessible(fieldUsername);
        ReflectionUtils.makeAccessible(fieldPassword);

        ReflectionUtils.setField(fieldUsername, loginRequestDto, "taxidobarba");
        ReflectionUtils.setField(fieldPassword, loginRequestDto, "taxidobarba");

        return loginRequestDto;
    }
}

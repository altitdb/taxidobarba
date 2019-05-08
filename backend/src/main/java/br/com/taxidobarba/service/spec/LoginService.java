package br.com.taxidobarba.service;

import br.com.taxidobarba.domain.request.dto.LoginRequestDTO;

public interface LoginService {

    public void login(LoginRequestDTO request);

}

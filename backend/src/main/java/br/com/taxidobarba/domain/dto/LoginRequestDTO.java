package br.com.taxidobarba.domain.dto;

import javax.validation.constraints.NotEmpty;

public class LoginRequestDTO {

	@NotEmpty(message = "Usuario deve ser informado")
	private String username;
	@NotEmpty(message = "Senha deve ser informada")
	private String password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}

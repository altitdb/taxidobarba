package br.com.taxidobarba.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.taxidobarba.domain.dto.LoginRequestDTO;
import br.com.taxidobarba.exception.AccessDeniedException;
import br.com.taxidobarba.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { UserRepository.class, LoginRequestDTO.class, LoginServiceBean.class })
public class LoginServiceBeanTest {

	@MockBean
	private UserRepository repository;
	@MockBean
	private LoginRequestDTO loginRequestDto;

	@Autowired
	private LoginService service;

	@Test(expected = AccessDeniedException.class)
	public void shouldValidateInvalidUser() {
		BDDMockito.given(repository.findByUsername(ArgumentMatchers.anyString())).willReturn(Optional.empty());
		service.login(loginRequestDto);
	}

}

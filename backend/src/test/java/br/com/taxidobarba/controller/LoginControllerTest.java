package br.com.taxidobarba.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Field;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.taxidobarba.domain.User;
import br.com.taxidobarba.domain.dto.LoginRequestDTO;
import br.com.taxidobarba.repository.UserRepository;
import br.com.taxidobarba.service.LoginServiceBean;

@RunWith(SpringRunner.class)
@WebMvcTest(value = { LoginController.class, LoginServiceBean.class })
public class LoginControllerTest {

	@MockBean
	private UserRepository repository;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void shouldValidateValidUserAndPasswordHttpStatusAccepted() {

		User mockUser = mockUser();
		LoginRequestDTO loginRequestDto = mockLoginRequestDTO();

		BDDMockito.given(repository.findByUsername(ArgumentMatchers.anyString())).willReturn(Optional.of(mockUser));

		try {
			String json = mapper.writeValueAsString(loginRequestDto);
			mockMvc.perform(post("/api/v1/login")
					.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
					.content(json)
					.accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
				).andExpect(status().isAccepted());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private LoginRequestDTO mockLoginRequestDTO() {
		LoginRequestDTO loginRequestDto = new LoginRequestDTO();

		Field fieldUsername = ReflectionUtils.findField(LoginRequestDTO.class, "username");
		Field fieldPassword = ReflectionUtils.findField(LoginRequestDTO.class, "password");

		ReflectionUtils.makeAccessible(fieldUsername);
		ReflectionUtils.makeAccessible(fieldPassword);

		ReflectionUtils.setField(fieldUsername, loginRequestDto, "taxidobarba");
		ReflectionUtils.setField(fieldPassword, loginRequestDto, "taxidobarba");

		return loginRequestDto;
	}

	private User mockUser() {
		User user = new User();
		user.setUsername("taxidobarba");
		user.setPassword("52007496FBC1E6093E711F0EBFD749A7957BDEFE44EE82DA80E2322848514FE3");
		return user;
	}
}

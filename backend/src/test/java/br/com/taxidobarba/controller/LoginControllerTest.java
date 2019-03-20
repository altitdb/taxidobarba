package br.com.taxidobarba.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.taxidobarba.domain.User;
import br.com.taxidobarba.domain.dto.LoginRequestDTO;
import br.com.taxidobarba.mock.LoginRequestDTOMock;
import br.com.taxidobarba.mock.UserMock;
import br.com.taxidobarba.repository.UserRepository;
import br.com.taxidobarba.service.LoginServiceBean;

@RunWith(SpringRunner.class)
@WebMvcTest(value = { LoginController.class, LoginServiceBean.class })
public class LoginControllerTest extends ControllerTest {

    @MockBean
    private UserRepository repository;
    private User mockUser = UserMock.mockUser();
    private LoginRequestDTO loginRequestDto = LoginRequestDTOMock.mockLoginRequestDTO();

    @Test
    public void shouldValidateValidUserAndPasswordHttpStatusAccepted() {

        BDDMockito.given(repository.findByUsername(ArgumentMatchers.anyString())).willReturn(Optional.of(mockUser));

        try {
            String json = mapper.writeValueAsString(loginRequestDto);
            mockMvc.perform(post("/api/v1/login")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isAccepted());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package br.com.taxidobarba.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.taxidobarba.domain.dto.DriverRequestDTO;
import br.com.taxidobarba.mock.DriverResquestDTOMock;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.service.DriverServiceBean;

@RunWith(SpringRunner.class)
@WebMvcTest(value = { DriverController.class, DriverServiceBean.class})
public class DriverControllerTest extends ControllerTest {

	@MockBean
	private DriverRepository repository;
	private DriverRequestDTO driverRequestDto = DriverResquestDTOMock.mockDriverRequestDTO();
	
	@Test
	public void shoulValidateRequestFindAllWithHttpStatusOk() {
		try {
			mockMvc.perform(get("/api/v1/driver")
					.accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
				).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void shoulValidateSaveDriverWithHttpStatusAccepted() {
		try {
			String json = mapper.writeValueAsString(driverRequestDto);
			mockMvc.perform(post("/api/v1/driver")
					.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
					.content(json)
					.accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
				).andExpect(status().isAccepted());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

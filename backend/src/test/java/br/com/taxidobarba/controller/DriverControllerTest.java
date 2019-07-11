package br.com.taxidobarba.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.request.dto.DriverRequestDTO;
import br.com.taxidobarba.mock.DriverResquestDTOMock;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.service.DriverServiceBean;

@RunWith(SpringRunner.class)
@WebMvcTest(value = { DriverController.class, DriverServiceBean.class })
public class DriverControllerTest extends ControllerTest {

    @MockBean
    private DriverRepository repository;
    private DriverRequestDTO driverRequestDto = DriverResquestDTOMock.mock();
    @Mock
    private Driver driver;

    @Test
    public void shoulValidateRequestFindAllWithHttpStatusOk() {
        try {
            mockMvc.perform(get("/api/v1/driver")
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isOk());
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
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isCreated());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shoulValidateDriverFindByIdHttpStatusOk() {
        BDDMockito.given(repository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(driver));
        try {
            mockMvc.perform(get("/api/v1/driver/1234654587"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shoulValidateDriverFindByIdNotReturnHttpStatusBadRequest() {
        BDDMockito.given(repository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            mockMvc.perform(get("/api/v1/driver/1234654587"))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

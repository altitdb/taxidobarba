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

import br.com.taxidobarba.domain.request.dto.CarRequestDTO;
import br.com.taxidobarba.mock.CarRequestDTOMock;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.service.impl.CarServiceBean;

@RunWith(SpringRunner.class)
@WebMvcTest(value = {CarController.class, CarServiceBean.class})
public class CarControllerTest extends ControllerTest{

    @MockBean
    private CarRepository repository;
    private CarRequestDTO carRequestDto = CarRequestDTOMock.mock();
    
    @Test
    public void shouldSaveCarWithResponseHttpAccepted() {
        try {
            String json = mapper.writeValueAsString(carRequestDto);
            mockMvc.perform(post("/api/v1/car")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isAccepted());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    @Test
    public void shouldReturnCarsWithResponseHttpOK() {
        try {
            mockMvc.perform(get("/api/v1/car")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

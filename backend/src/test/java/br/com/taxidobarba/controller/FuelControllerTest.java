package br.com.taxidobarba.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.request.dto.FuelRequestDTO;
import br.com.taxidobarba.mock.FuelRequestDTOMock;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.repository.FuelRepository;
import br.com.taxidobarba.service.impl.FuelServiceBean;

@RunWith(SpringRunner.class)
@WebMvcTest(value = { FuelController.class, FuelServiceBean.class })
public class FuelControllerTest extends ControllerTest {

    @MockBean
    private CarRepository carRepository;
    @MockBean
    private DriverRepository driverRepository;
    @MockBean
    private FuelRepository repository;
    private FuelRequestDTO fuelRequest;
    @Mock
    private Car car;
    @Mock
    private Driver driver;
    
    @Before
    public void init() {
        fuelRequest = FuelRequestDTOMock.mock();
        BDDMockito.given(driverRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(driver));
        BDDMockito.given(carRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(car));
    }
    
    @Test
    public void shouldValidateRequestWithCarIdNonExistentHttpStatusBadRequest() {
        BDDMockito.given(carRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            String json = mapper.writeValueAsString(fuelRequest);
            mockMvc.perform(post("/api/v1/fuel")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldValidateRequestWithDriverIdNonExistentHttpStatusBadRequest() {
        BDDMockito.given(driverRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            String json = mapper.writeValueAsString(fuelRequest);
            mockMvc.perform(post("/api/v1/fuel")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldSaveFueltHttpStatusAccepted() {
        try {
            String json = mapper.writeValueAsString(fuelRequest);
            mockMvc.perform(post("/api/v1/fuel")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isAccepted());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

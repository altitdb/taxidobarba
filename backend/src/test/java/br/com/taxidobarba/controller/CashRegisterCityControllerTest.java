package br.com.taxidobarba.controller;

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

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.dto.CashRegisterCityRequestDTO;
import br.com.taxidobarba.mock.CashRegisterCityRequestDTOMock;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.CashRegisterCityRepository;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.service.CashRegisterCityServiceBean;

@RunWith(SpringRunner.class)
@WebMvcTest(value = {CashRegisterCityController.class, CashRegisterCityServiceBean.class})
public class CashRegisterCityControllerTest extends ControllerTest{

    @MockBean
    private CarRepository carRepository;
    @MockBean
    private DriverRepository driverRepository;
    @MockBean
    private CashRegisterCityRepository cashRegisterCityRepository;
    @Mock
    private Car car;
    @Mock
    private Driver driver;
    private CashRegisterCityRequestDTO cashRegisterRequestSuccess = CashRegisterCityRequestDTOMock.mockSuccess();
    private CashRegisterCityRequestDTO cashRegisterRequestFail = CashRegisterCityRequestDTOMock.mockFail();
    
    @Test
    public void shouldValidateRequestWithCarIdNonExistentHttpStatusBadRequest() {
        BDDMockito.given(driverRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(driver));
        BDDMockito.given(carRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            String json = mapper.writeValueAsString(cashRegisterRequestSuccess);
            mockMvc.perform(post("/api/v1/cash/city")
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
        BDDMockito.given(carRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(car));
        BDDMockito.given(driverRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            String json = mapper.writeValueAsString(cashRegisterRequestSuccess);
            mockMvc.perform(post("/api/v1/cash/city")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldSaveCashRegisterCityRequestHttpStatusAccepted() {
        BDDMockito.given(carRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(car));
        BDDMockito.given(driverRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(driver));
        try {
            String json = mapper.writeValueAsString(cashRegisterRequestSuccess);
            mockMvc.perform(post("/api/v1/cash/city")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isAccepted());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldValidateCashRegisterCityRequestStartKmBiggerThenEndKmHttpStatusBadRequest() {
        BDDMockito.given(carRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(car));
        BDDMockito.given(driverRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(driver));
        try {
            String json = mapper.writeValueAsString(cashRegisterRequestFail);
            mockMvc.perform(post("/api/v1/cash/city")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

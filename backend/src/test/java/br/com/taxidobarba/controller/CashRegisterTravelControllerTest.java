package br.com.taxidobarba.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import br.com.taxidobarba.domain.CashRegisterTravel;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.request.dto.CashRegisterTravelRequestDTO;
import br.com.taxidobarba.mock.CashRegisterTravelRequestDTOMock;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.CashRegisterTravelRepository;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.service.CashRegisterTravelServiceBean;

@RunWith(SpringRunner.class)
@WebMvcTest(value = {CashRegisterTravelController.class, CashRegisterTravelServiceBean.class})
public class CashRegisterTravelControllerTest extends ControllerTest{

    @MockBean
    private CarRepository carRepository;
    @MockBean
    private DriverRepository driverRepository;
    @MockBean
    private CashRegisterTravelRepository cashRegisterTravelRepository;
    @Mock
    private Car car;
    @Mock
    private Driver driver;
    private CashRegisterTravelRequestDTO cashRegisterRequest;
    
    @Before
    public void init() {
        cashRegisterRequest = CashRegisterTravelRequestDTOMock.mock();
        BDDMockito.given(driverRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(driver));
        BDDMockito.given(carRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(car));
        
        CashRegisterTravel travel = new CashRegisterTravel.CashRegisterTravelBuilder()
                                        .withAveragePriceKm(BigDecimal.ONE)
                                        .withCar(car)
                                        .withCity("MARINGA")
                                        .withDate(LocalDate.now())
                                        .withDriver(driver)
                                        .withKm(BigDecimal.TEN)
                                        .withNetValue(BigDecimal.TEN)
                                        .withPercentualDriver(BigDecimal.ONE)
                                        .withPrice(BigDecimal.TEN)
                                        .withValueDriver(BigDecimal.TEN)
                                        .build();
        BDDMockito.given(cashRegisterTravelRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(travel));
        BDDMockito.given(driver.getPercentualTravel()).willReturn(BigDecimal.TEN);
        BDDMockito.given(driver.getId()).willReturn("123");
        BDDMockito.given(car.getId()).willReturn("123");
        BDDMockito.given(driver.getName()).willReturn("JOSE");
        BDDMockito.given(car.getName()).willReturn("GOL");
    }
    
    @Test
    public void shouldValidateRequestWithCarIdNonExistentHttpStatusBadRequest() {
        BDDMockito.given(carRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            String json = mapper.writeValueAsString(cashRegisterRequest);
            mockMvc.perform(post("/api/v1/cash/travel")
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
            String json = mapper.writeValueAsString(cashRegisterRequest);
            mockMvc.perform(post("/api/v1/cash/travel")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldSaveCashRegisterTravelRequestHttpStatusAccepted() {
        try {
            String json = mapper.writeValueAsString(cashRegisterRequest);
            mockMvc.perform(post("/api/v1/cash/travel")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isAccepted());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldValidateRequestUpdateWithCarIdNonExistentHttpStatusBadRequest() {
        BDDMockito.given(carRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            String json = mapper.writeValueAsString(cashRegisterRequest);
            mockMvc.perform(put("/api/v1/cash/travel/123")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldValidateRequestUpdateWithDriverIdNonExistentHttpStatusBadRequest() {
        BDDMockito.given(driverRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            String json = mapper.writeValueAsString(cashRegisterRequest);
            mockMvc.perform(put("/api/v1/cash/travel/123")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldValidateRequestUpdateWithTravelIdNonExistentHttpStatusBadRequest() {
        BDDMockito.given(cashRegisterTravelRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            String json = mapper.writeValueAsString(cashRegisterRequest);
            mockMvc.perform(put("/api/v1/cash/travel/123")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldSaveCashRegisterTravelRequestUpdateHttpStatusAccepted() {
        try {
            String json = mapper.writeValueAsString(cashRegisterRequest);
            mockMvc.perform(put("/api/v1/cash/travel/123")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

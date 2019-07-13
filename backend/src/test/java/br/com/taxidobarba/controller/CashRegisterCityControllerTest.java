package br.com.taxidobarba.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import br.com.taxidobarba.domain.CashRegisterCity;
import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.request.dto.CashRegisterCityRequestDTO;
import br.com.taxidobarba.mock.CashRegisterCityRequestDTOMock;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.CashRegisterCityRepository;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.service.CashRegisterCityServiceBean;
import br.com.taxidobarba.validator.RequestValidator;

@RunWith(SpringRunner.class)
@WebMvcTest(value = {CashRegisterCityController.class, RequestValidator.class, CashRegisterCityServiceBean.class})
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
    @Mock
    private CashRegisterCity cashRegisterCity;
    private CashRegisterCityRequestDTO cashRegisterRequestSuccess;
    private CashRegisterCityRequestDTO cashRegisterRequestFail;
    
    @Before
    public void init() {
        cashRegisterRequestFail = CashRegisterCityRequestDTOMock.mockFail();
        cashRegisterRequestSuccess = CashRegisterCityRequestDTOMock.mockSuccess();
        
        CashRegisterCity city = new CashRegisterCity.CashRegisterCityBuilder()
                                    .withCar(car)
                                    .withDate(LocalDate.now())
                                    .withDriver(driver)
                                    .withEndKm(BigDecimal.TEN)
                                    .withDifference(BigDecimal.ONE)
                                    .withKm(BigDecimal.TEN)
                                    .withOtherKm(BigDecimal.ONE)
                                    .withPrice(BigDecimal.TEN)
                                    .withPriceKmDriver(BigDecimal.ONE)
                                    .withStartKm(BigDecimal.ZERO)
                                    .withTotalReceived(BigDecimal.TEN)
                                    .build();
        
        BDDMockito.given(driverRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(driver));
        BDDMockito.given(carRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(car));
        BDDMockito.given(cashRegisterCityRepository.save(ArgumentMatchers.any(CashRegisterCity.class))).willReturn(city);
        BDDMockito.given(cashRegisterCityRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(city));
        BDDMockito.given(driver.getPriceKm()).willReturn(BigDecimal.TEN);
        BDDMockito.given(driver.getId()).willReturn("123");
        BDDMockito.given(car.getId()).willReturn("123");
        BDDMockito.given(driver.getName()).willReturn("JOSE");
        BDDMockito.given(car.getName()).willReturn("GOL");
    }
    
    @Test
    public void shouldValidateRequestWithCarIdNonExistentHttpStatusBadRequest() {
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
        try {
            String json = mapper.writeValueAsString(cashRegisterRequestSuccess);
            mockMvc.perform(post("/api/v1/cash/city")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isCreated());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldValidateCashRegisterCityRequestStartKmBiggerThenEndKmHttpStatusBadRequest() {
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
    
    
    @Test
    public void shouldValidateCashRegisterCityRequestWithDateAndDriverAlreadyExistingHttpStatusBadRequest() {
        BDDMockito.given(cashRegisterCityRepository.findByDriverAndDate(ArgumentMatchers.any(Driver.class),
                ArgumentMatchers.any(LocalDate.class))).willReturn(Optional.of(cashRegisterCity));
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
    public void shouldValidateCashRegisterCityRequestUpdateWithDateAndDriverAlreadyExistingHttpStatusBadRequest() {
        BDDMockito.given(cashRegisterCityRepository.findByDriverAndDateAndIdNot(ArgumentMatchers.any(Driver.class),
                ArgumentMatchers.any(LocalDate.class), ArgumentMatchers.any())).willReturn(Optional.of(cashRegisterCity));
        try {
            String json = mapper.writeValueAsString(cashRegisterRequestSuccess);
            mockMvc.perform(put("/api/v1/cash/city/123456")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldValidateCashRegisterCityRequestUpdateStartKmBiggerThenEndKmHttpStatusBadRequest() {
        try {
            String json = mapper.writeValueAsString(cashRegisterRequestFail);
            mockMvc.perform(put("/api/v1/cash/city/123456")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldUpdateCashRegisterCityRequestHttpStatusOk() {
        try {
            String json = mapper.writeValueAsString(cashRegisterRequestSuccess);
            mockMvc.perform(put("/api/v1/cash/city/456987")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldValidateRequestUpdateWithCarIdNonExistentHttpStatusBadRequest() {
        BDDMockito.given(carRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            String json = mapper.writeValueAsString(cashRegisterRequestSuccess);
            mockMvc.perform(put("/api/v1/cash/city/89564")
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
            String json = mapper.writeValueAsString(cashRegisterRequestSuccess);
            mockMvc.perform(put("/api/v1/cash/city/45687")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldValidateRequestUpdateWithIdNonExistentHttpStatusBadRequest() {
        BDDMockito.given(cashRegisterCityRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            String json = mapper.writeValueAsString(cashRegisterRequestSuccess);
            mockMvc.perform(put("/api/v1/cash/city/45687")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldValidateRequestWithIdNonExistentHttpStatusBadRequest() {
        BDDMockito.given(cashRegisterCityRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            mockMvc.perform(get("/api/v1/cash/city/45687")
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldReturnTravelResponseDTOHttpStatusOk() {
        try {
            mockMvc.perform(get("/api/v1/cash/city/45687")
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

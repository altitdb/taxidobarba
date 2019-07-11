package br.com.taxidobarba.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import br.com.taxidobarba.domain.request.dto.TrafficTicketRequestDTO;
import br.com.taxidobarba.mock.TrafficTicketRequestDTOMock;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.repository.PaymentTrafficTicketRepository;
import br.com.taxidobarba.repository.TrafficTicketRepository;
import br.com.taxidobarba.service.TrafficTicketServiceBean;

@RunWith(SpringRunner.class)
@WebMvcTest(value = { TrafficTicketController.class, TrafficTicketServiceBean.class })
public class TrafficTicketControllerTest extends ControllerTest{

    @MockBean
    private CarRepository carRepository;
    @MockBean
    private DriverRepository driverRepository;
    @MockBean
    private TrafficTicketRepository trafficTicketRepository;
    @MockBean
    private PaymentTrafficTicketRepository paymentTrafficTicketRepository;
    @Mock
    private Car car;
    @Mock
    private Driver driver;
    private TrafficTicketRequestDTO trafficTicketRequestDtoFail;
    private TrafficTicketRequestDTO trafficTicketRequestDtoSuccess;
    
    @Before
    public void init() {
        trafficTicketRequestDtoFail = TrafficTicketRequestDTOMock.mockFail();
        trafficTicketRequestDtoSuccess = TrafficTicketRequestDTOMock.mockSuccess();
        BDDMockito.given(driverRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(driver));
        BDDMockito.given(carRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(car));
    }
    
    @Test
    public void shouldValidateRequestWithCarIdNonExistentHttpStatusBadRequest() {
        BDDMockito.given(carRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            String json = mapper.writeValueAsString(trafficTicketRequestDtoFail);
            mockMvc.perform(post("/api/v1/traffic-ticket")
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
            String json = mapper.writeValueAsString(trafficTicketRequestDtoFail);
            mockMvc.perform(post("/api/v1/traffic-ticket")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldValidateRequestWithInvalidPointsHttpStatusBadRequest() {
        try {
            String json = mapper.writeValueAsString(trafficTicketRequestDtoFail);
            mockMvc.perform(post("/api/v1/traffic-ticket")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldSaveHttpStatusAccepted() {
        try {
            String json = mapper.writeValueAsString(trafficTicketRequestDtoSuccess);
            mockMvc.perform(post("/api/v1/traffic-ticket")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isAccepted());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldReturnAllByOpenedStatusHttpStatusOk() {
        try {
            mockMvc.perform(get("/api/v1/traffic-ticket?status=OPENED")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldReturnAllByPaidStatusHttpStatusOk() {
        try {
            mockMvc.perform(get("/api/v1/traffic-ticket?status=PAID")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

package br.com.taxidobarba.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.taxidobarba.domain.PaymentTrafficTicket;
import br.com.taxidobarba.domain.TrafficTicket;
import br.com.taxidobarba.domain.request.dto.PaymentTrafficTicketRequestDTO;
import br.com.taxidobarba.mock.PaymentTrafficTicketRequestDTOMock;
import br.com.taxidobarba.repository.PaymentTrafficTicketRepository;
import br.com.taxidobarba.repository.TrafficTicketRepository;
import br.com.taxidobarba.service.spec.PaymentTrafficTicketService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = { PaymentTrafficTicketController.class, PaymentTrafficTicketService.class })
public class PaymentTrafficTicketControllerTest extends ControllerTest {

    @MockBean
    private PaymentTrafficTicketRepository paymentTrafficTicketRepository;
    @MockBean
    private TrafficTicketRepository trafficTicketRepository;
    @MockBean
    private TrafficTicket trafficTicket;
    @MockBean
    private PaymentTrafficTicket paymentTrafficTicket;
    private PaymentTrafficTicketRequestDTO trafficTicketRequestDtoMockSuccess;
    private PaymentTrafficTicketRequestDTO trafficTicketRequestDtoMockFail;

    @Before
    public void init() {
        trafficTicketRequestDtoMockSuccess = PaymentTrafficTicketRequestDTOMock.mockSuccess();
        trafficTicketRequestDtoMockFail = PaymentTrafficTicketRequestDTOMock.mockFail();
        BDDMockito.given(trafficTicketRepository.findById(ArgumentMatchers.anyString()))
                .willReturn(Optional.of(trafficTicket));
        BDDMockito.given(trafficTicket.getValue()).willReturn(new BigDecimal("125"));
    }
    
    @Test
    public void shouldValidateRequestWithTrafficTicketIdNonExistentHttpStatusBadRequest() {
        BDDMockito.given(trafficTicketRepository.findById(ArgumentMatchers.anyString())).willReturn(Optional.empty());
        try {
            String json = mapper.writeValueAsString(trafficTicketRequestDtoMockSuccess);
            mockMvc.perform(post("/api/v1/traffic-ticket/payment")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldValidateRequestWithValueGreaterThanTheTrafficTicketHttpStatusBadRequest() {
        try {
            String json = mapper.writeValueAsString(trafficTicketRequestDtoMockFail);
            mockMvc.perform(post("/api/v1/traffic-ticket/payment")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldValidateRequestWithPartialValueGreaterThanTheTrafficTicketHttpStatusBadRequest() {
        try {
            String json = mapper.writeValueAsString(trafficTicketRequestDtoMockSuccess);
            mockMvc.perform(post("/api/v1/traffic-ticket/payment")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isAccepted());
            
            try {
                
                BDDMockito.given(paymentTrafficTicketRepository.findByTrafficTicket(ArgumentMatchers.any(TrafficTicket.class)))
                .willReturn(Arrays.asList(paymentTrafficTicket));
                BDDMockito.given(paymentTrafficTicket.getValue()).willReturn(BigDecimal.TEN);
                
                json = mapper.writeValueAsString(trafficTicketRequestDtoMockSuccess);
                mockMvc.perform(post("/api/v1/traffic-ticket/payment")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                        .andExpect(status().isBadRequest());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void shouldSaveHttpStatusAccepted() {
        try {
            String json = mapper.writeValueAsString(trafficTicketRequestDtoMockSuccess);
            mockMvc.perform(post("/api/v1/traffic-ticket/payment")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isAccepted());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

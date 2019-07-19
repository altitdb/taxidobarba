package br.com.taxidobarba.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.repository.CashRegisterCityRepository;
import br.com.taxidobarba.repository.CashRegisterTravelRepository;
import br.com.taxidobarba.repository.DriverRepository;
import br.com.taxidobarba.repository.FuelRepository;
import br.com.taxidobarba.service.ActualMonthSummaryServiceBean;

@RunWith(SpringRunner.class)
@WebMvcTest(value = { ActualMonthSummaryController.class, ActualMonthSummaryServiceBean.class })
public class ActualMonthSummaryControllerTest extends ControllerTest{

    @MockBean
    private CashRegisterCityRepository cashRegisterCityRepository;
    @MockBean
    private CashRegisterTravelRepository cashRegisterTravelRepository;
    @MockBean
    private FuelRepository fuelRepository;
    @MockBean
    private CarRepository carRepository;
    @MockBean
    private DriverRepository driverRepository;
    
    @Test
    public void shouldReturnHttpStatusOk() {
        try {
            mockMvc.perform(get("/api/v1/actual-month-summary")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

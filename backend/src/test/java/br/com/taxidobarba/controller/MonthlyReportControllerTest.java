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
import br.com.taxidobarba.service.MonthlyReportServiceBean;

@RunWith(SpringRunner.class)
@WebMvcTest(value = { MonthlyReportController.class, MonthlyReportServiceBean.class })
public class MonthlyReportControllerTest extends ControllerTest {

    @MockBean
    private CashRegisterCityRepository cashRegisterCityRepository;
    @MockBean
    private CashRegisterTravelRepository cashRegisterTravelRepository;
    @MockBean
    private CarRepository carRepository;
    @MockBean
    private DriverRepository driverRepository;
    @MockBean
    private FuelRepository fuelRepository;
    
    @Test
    public void shouldReturnHttpStatusOk() {
        try {
            mockMvc.perform(get("/api/v1/monthly-report")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

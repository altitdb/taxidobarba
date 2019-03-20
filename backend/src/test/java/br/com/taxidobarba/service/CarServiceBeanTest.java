package br.com.taxidobarba.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.dto.CarRequestDTO;
import br.com.taxidobarba.exception.BusinessExpetion;
import br.com.taxidobarba.mock.CarMock;
import br.com.taxidobarba.mock.CarRequestDTOMock;
import br.com.taxidobarba.repository.CarRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CarRepository.class, CarServiceBean.class })
public class CarServiceBeanTest {

    @MockBean
    private CarRepository repository;
    @Autowired
    private CarService service;
    private CarRequestDTO carRequestDto = CarRequestDTOMock.mockCarRequestDTO();
    private Car car = CarMock.mockCar();

    @Test(expected = BusinessExpetion.class)
    public void shouldValidateCarWithLicensePlateAlreadyExisting() {
        BDDMockito.given(repository.findByLicensePlate(ArgumentMatchers.anyString())).willReturn(Optional.of(car));
        service.save(carRequestDto);
    }

}

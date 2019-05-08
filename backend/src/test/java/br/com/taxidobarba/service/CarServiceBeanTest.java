package br.com.taxidobarba.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.taxidobarba.domain.Car;
import br.com.taxidobarba.domain.request.dto.CarRequestDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.mock.CarRequestDTOMock;
import br.com.taxidobarba.repository.CarRepository;
import br.com.taxidobarba.service.impl.CarServiceBean;
import br.com.taxidobarba.service.spec.CarService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CarRepository.class, CarServiceBean.class })
public class CarServiceBeanTest {

    @MockBean
    private CarRepository repository;
    @Mock
    private Car car;
    @Autowired
    private CarService service;
    private CarRequestDTO carRequestDto = CarRequestDTOMock.mock();

    @Test(expected = BusinessException.class)
    public void shouldValidateCarWithLicensePlateAlreadyExisting() {
        BDDMockito.given(repository.findByLicensePlate(ArgumentMatchers.anyString())).willReturn(Optional.of(car));
        service.save(carRequestDto);
    }

}

package br.com.taxidobarba.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.dto.DriverRequestDTO;
import br.com.taxidobarba.domain.dto.DriverResponseDTO;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.mock.DriverResquestDTOMock;
import br.com.taxidobarba.repository.DriverRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DriverRepository.class, DriverServiceBean.class })
public class DriverServiceBeanTest {

    @MockBean
    private DriverRepository repository;
    @Autowired
    private DriverService service;
    @Mock
    private Driver driver;
    private DriverRequestDTO driverRequestDto = DriverResquestDTOMock.mock();

    @Test
    public void shouldSaveDriver() {
        service.save(driverRequestDto);
    }

    @Test(expected = BusinessException.class)
    public void shouldValidateDriverWithEqualsAttributes() {
        BDDMockito.given(repository.findByTaxIdentifier(ArgumentMatchers.anyString())).willReturn(Optional.of(driver));
        service.save(driverRequestDto);
    }

    @Test
    public void shouldReturnDriverById() {
        BDDMockito.given(repository.findById(ArgumentMatchers.anyString())).willReturn(Optional.of(driver));
        
        DriverResponseDTO driverResponseDTO = service.findById("ABCDFRE569874");
       
        Assert.assertNotNull(driverResponseDTO);
    }
}

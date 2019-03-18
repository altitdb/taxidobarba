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

import br.com.taxidobarba.domain.Driver;
import br.com.taxidobarba.domain.dto.DriverRequestDTO;
import br.com.taxidobarba.exception.BusinessExpetion;
import br.com.taxidobarba.mock.DriverMock;
import br.com.taxidobarba.mock.DriverResquestDTOMock;
import br.com.taxidobarba.repository.DriverRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DriverRepository.class, DriverServiceBean.class })
public class DriverServiceBeanTest {

	@MockBean
	private DriverRepository repository;
	@Autowired
	private DriverService service;
	private Driver driver = DriverMock.mockDriver();
	private DriverRequestDTO driverRequestDto = DriverResquestDTOMock.mockDriverRequestDTO();

	@Test
	public void shouldSaveDriver() {		
		service.save(driverRequestDto);
	}

	@Test(expected = BusinessExpetion.class)
	public void shouldValidateDriverWithEqualsAttributes() {
		BDDMockito.given(repository.findByTaxIdentifier(ArgumentMatchers.anyString())).willReturn(Optional.of(driver));
		service.save(driverRequestDto);
	}
}
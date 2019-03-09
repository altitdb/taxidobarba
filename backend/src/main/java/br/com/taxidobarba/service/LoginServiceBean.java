package br.com.taxidobarba.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taxidobarba.domain.User;
import br.com.taxidobarba.domain.dto.LoginRequestDTO;
import br.com.taxidobarba.exception.AccessDeniedException;
import br.com.taxidobarba.repository.UserRepository;
import br.com.taxidobarba.utils.EncoderUtils;

@Service
public class LoginServiceBean implements LoginService {

	private static final Logger LOG = LogManager.getLogger(LoginServiceBean.class);

	@Autowired
	private UserRepository repository;

	@Override
	public void login(LoginRequestDTO request) {

		User user = getUserByUsername(request.getUsername());
		String passwordRequestEncoded = encoderPasswordRequest(request.getPassword());
		validateUser(user, passwordRequestEncoded);
		updateLastAccessUser(user);

	}

	private User getUserByUsername(String username) {
		Optional<User> user = repository.findByUsername(username);
		if (user.isPresent()) {
			return user.get();
		}
		throw new AccessDeniedException("Usuario e/ou senha invalidos.");
	}

	private String encoderPasswordRequest(String passwordRequest) {
		EncoderUtils encoderUtils = new EncoderUtils();
		return encoderUtils.encoder(passwordRequest);
	}

	private void validateUser(User user, String passwordRequestEncoded) {
		if (!user.getPassword().equals(passwordRequestEncoded)) {
			throw new AccessDeniedException("Usuario e/ou senha invalidos.");
		}
		LOG.info("Login efetuado com sucesso.");
	}
	
	private void updateLastAccessUser(User user) {
		user.setLastAccess(LocalDateTime.now());
		repository.save(user);
		LOG.debug("Data/hora de ultimo acesso atualizados com sucesso.");
	}

}

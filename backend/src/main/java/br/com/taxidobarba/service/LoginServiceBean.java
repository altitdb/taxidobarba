package br.com.taxidobarba.service;

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
    }

    private User getUserByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new AccessDeniedException("Usuario e/ou senha invalidos."));
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

}

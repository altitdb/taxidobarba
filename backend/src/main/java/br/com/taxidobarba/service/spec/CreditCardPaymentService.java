package br.com.taxidobarba.service.spec;

import org.springframework.web.multipart.MultipartFile;

public interface CreditCardPaymentService {

    public void save(MultipartFile file);

}

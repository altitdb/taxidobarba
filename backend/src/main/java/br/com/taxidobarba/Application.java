package br.com.taxidobarba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
	System.setProperty("spring.devtools.restart.enabled", "true");
	SpringApplication.run(Application.class, args);
    }
}

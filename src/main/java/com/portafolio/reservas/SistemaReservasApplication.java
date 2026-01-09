package com.portafolio.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SistemaReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaReservasApplication.class, args);
	}

}

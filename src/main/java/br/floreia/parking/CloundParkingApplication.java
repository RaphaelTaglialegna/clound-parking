package br.floreia.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.floreia.parking.repository")
public class CloundParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloundParkingApplication.class, args);
	}

}

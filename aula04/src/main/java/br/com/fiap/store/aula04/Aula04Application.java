package br.com.fiap.store.aula04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Aula04Application {

	public static void main(String[] args) {
		SpringApplication.run(Aula04Application.class, args);
	}

}

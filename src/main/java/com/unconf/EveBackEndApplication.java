package com.unconf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages={"com.unconf","bitoflife.chatterbean"})
public class EveBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(EveBackEndApplication.class, args);
	}
}

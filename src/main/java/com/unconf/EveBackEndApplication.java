package com.unconf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.unconf")
public class EveBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(EveBackEndApplication.class, args);
	}
}

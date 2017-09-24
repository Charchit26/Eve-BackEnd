package com.unconf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.AliceBotMother;

@SpringBootApplication(scanBasePackages={"com.unconf","bitoflife.chatterbean"})
public class EveBackEndApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EveBackEndApplication.class, args);
	}
}

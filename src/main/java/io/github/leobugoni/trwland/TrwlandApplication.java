package io.github.leobugoni.trwland;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrwlandApplication {
	static Logger logger = LoggerFactory.getLogger(TrwlandApplication.class);

	public static void main(String[] args) {
		logger.info("Teste");
		SpringApplication.run(TrwlandApplication.class, args);
	}

}

package com.modbiquity.test.atms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.modbiquity.test.atms")
public class AtmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmsApplication.class, args);
	}

}

package com.ll.naengcipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NaengCipeApplication {
	public static void main(String[] args) {
		SpringApplication.run(NaengCipeApplication.class, args);
	}
}

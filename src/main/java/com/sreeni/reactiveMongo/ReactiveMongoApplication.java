package com.sreeni.reactiveMongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
@EnableReactiveMongoRepositories
public class ReactiveMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMongoApplication.class, args);
	}

}

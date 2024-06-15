package com.sreeni.reactiveMongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.mongodb.reactivestreams.client.MongoClient;

@Configuration
public class ReactiveMongoTemplateConfig {
	
	@Autowired
	MongoClient mongoClient;
	
	@Value("${spring.data.mongodb.database}")
	private String database=null;
	
	@Bean
	public ReactiveMongoTemplate mongoTemplate() throws Exception {
		return new ReactiveMongoTemplate(mongoClient,database);
	}

}

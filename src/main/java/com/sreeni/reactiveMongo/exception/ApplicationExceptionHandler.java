package com.sreeni.reactiveMongo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(Exception.class)
	public Mono<ResponseEntity<String>> handleGenericException(Exception ex) {
		log.info("handleGenericException :: ",ex);
		return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage()));
	}
	
	@ExceptionHandler(ApplicationAPIException.class)
	public Mono<ResponseEntity<String>> handleApplicationException(ApplicationAPIException ex) {
		log.info("handleApplicationException :: ",ex);
		return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage()));
	}

}

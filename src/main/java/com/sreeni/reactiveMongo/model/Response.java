package com.sreeni.reactiveMongo.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class Response {

	private String message;

	private Date timestamp;

	private String statusCode;

}

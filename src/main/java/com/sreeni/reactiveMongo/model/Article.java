package com.sreeni.reactiveMongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Article {
	
	@Id
	private String articleId;
	private String name;
	private int pagesCount;
	private String author;
	private String type;
	private String publishDate;
	private String subject;
}

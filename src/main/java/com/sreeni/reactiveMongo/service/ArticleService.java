package com.sreeni.reactiveMongo.service;

import java.util.List;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.sreeni.reactiveMongo.exception.ApplicationAPIException;
import com.sreeni.reactiveMongo.model.Article;
import com.sreeni.reactiveMongo.utils.Utils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ArticleService {

	ReactiveMongoTemplate reactiveMongoTemplate;

	public ArticleService(ReactiveMongoTemplate reactiveMongoTemplate) {
		this.reactiveMongoTemplate = reactiveMongoTemplate;
	}

	public Mono<Article> saveArticle(Article article) throws ApplicationAPIException {
		article.setArticleId(Utils.getUUID());
		return reactiveMongoTemplate.save(article);
	}

	public Mono<Article> updateArtical(String articleId, Article article) throws ApplicationAPIException {
		Query query = new Query(Criteria.where("articleId").is(articleId));
		Update update = new Update().set("type", article.getType());
		return reactiveMongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true),
				Article.class);
	}

	public Flux<Article> getAllArticles() throws ApplicationAPIException {
		return reactiveMongoTemplate.findAll(Article.class, "article");
	}

	public Flux<Article> findArticlesByAuthor(String author) throws ApplicationAPIException {
		Query query = new Query(Criteria.where("author").is(author));
		return reactiveMongoTemplate.find(query, Article.class, "article");

	}

	public Mono<Article> getArticleById(String articleId) throws ApplicationAPIException {
		Query query = new Query(Criteria.where("articleId").is(articleId));
		return reactiveMongoTemplate.findOne(query, Article.class, "article");
	}

	public Flux<Article> getArticles(List<String> articleIdList) throws ApplicationAPIException {
		Query query = new Query(Criteria.where("articleId").in(articleIdList));
		return reactiveMongoTemplate.find(query, Article.class, "article");
	}
}

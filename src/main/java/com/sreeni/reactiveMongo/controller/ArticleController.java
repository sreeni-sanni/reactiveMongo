package com.sreeni.reactiveMongo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sreeni.reactiveMongo.model.Article;
import com.sreeni.reactiveMongo.service.ArticleService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class ArticleController {

	ArticleService articleService;

	public ArticleController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}

	@PostMapping(value = "/article", produces = { "application/json" }, consumes = { "application/json" })
	public Mono<ResponseEntity<String>> createArticle(@RequestBody Article article) {
		return articleService.saveArticle(article).map(res -> ResponseEntity.status(HttpStatus.OK)
				.body("Article is created successfully " + res.getArticleId()));

	}

	@PutMapping(value = "/article/{articleId}", produces = { "application/json" }, consumes = { "application/json" })
	public Mono<ResponseEntity<Article>> updateArticle(@PathVariable String articleId, @RequestBody Article article)  {
		return articleService.updateArtical(articleId,article).map(res -> ResponseEntity.status(HttpStatus.OK).body(res));
	}

	@GetMapping(value = "/articles", produces = { "application/json" }, consumes = { "application/json" })
	public Flux<Article> getAllArticles() {
		return articleService.getAllArticles();

	}
	
	@GetMapping(value = "/articlesByAuthor", produces = { "application/json" }, consumes = { "application/json" })
	public Flux<Article> getArticlesByAuthor(@RequestParam String author) {
		return articleService.findArticlesByAuthor(author);

	}

	@GetMapping(value = "/article/{articleId}", produces = { "application/json" }, consumes = { "application/json" })
	public Mono<Article> getArticleById(@PathVariable String articleId) {
		return articleService.getArticleById(articleId);

	}
	
	@PostMapping(value = "/getArticles", produces = { "application/json" }, consumes = { "application/json" })
	public Flux<Article> getArticles(@RequestBody List<String> articleIdList) {
		return articleService.getArticles(articleIdList);

	}
}

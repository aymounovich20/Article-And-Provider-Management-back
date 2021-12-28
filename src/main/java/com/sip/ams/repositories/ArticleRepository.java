package com.sip.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sip.ams.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}

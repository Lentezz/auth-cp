package edu.authcp.service;

import edu.authcp.dto.ArticleDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    ArticleDto createArticle(ArticleDto articleDto, String author);

    List<ArticleDto> findAllArticles();
}

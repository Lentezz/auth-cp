package edu.authcp.service.impl;

import edu.authcp.dto.ArticleDto;
import edu.authcp.entity.Article;
import edu.authcp.entity.Blog;
import edu.authcp.exception.BlogNotFoundException;
import edu.authcp.repository.ArticleRepository;
import edu.authcp.repository.BlogRepository;
import edu.authcp.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    private final BlogRepository blogRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ArticleDto createArticle(ArticleDto articleDto, String author) throws BlogNotFoundException{
        Article article = modelMapper.map(articleDto, Article.class);
        article.setDate(new Date());
        article.setAuthor(author);
        Blog blog = blogRepository.findByAuthor(author).orElseThrow(() ->
                new BlogNotFoundException(String.format("Blog with author '%s' not found.", author))
        );
        article = articleRepository.save(article);
        blog.getArticleList().add(article);
        blogRepository.save(blog);
        return modelMapper.map(article, ArticleDto.class);
    }

    @Override
    public List<ArticleDto> findAllArticles() {
        return articleRepository.findAll().stream()
                .map(x -> modelMapper.map(x, ArticleDto.class))
                .collect(Collectors.toList());
    }


}
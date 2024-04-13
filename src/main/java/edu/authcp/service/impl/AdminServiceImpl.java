package edu.authcp.service.impl;

import edu.authcp.dto.ArticleDto;
import edu.authcp.dto.BlogDto;
import edu.authcp.entity.Article;
import edu.authcp.entity.Blog;
import edu.authcp.exception.ArticleNotFoundException;
import edu.authcp.exception.BlogNotFoundException;
import edu.authcp.repository.ArticleRepository;
import edu.authcp.repository.BlogRepository;
import edu.authcp.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ArticleRepository articleRepository;

    private final BlogRepository blogRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    public void deleteAllBlogs(){
        articleRepository.deleteAll();
        blogRepository.deleteAll();
    }

    @Override
    public BlogDto deleteArticleById(String id) {
        Article article = articleRepository.findById(id).orElseThrow(() ->
                new ArticleNotFoundException("Nu article with such id founded."));
        String author = article.getAuthor();
        Blog blog = blogRepository.findByAuthor(author).orElseThrow(() ->
                new BlogNotFoundException("Article not founded in blogs."));
        blog.getArticleList().remove(article);
        articleRepository.deleteById(id);
        return modelMapper.map(blogRepository.save(blog), BlogDto.class);

    }
}

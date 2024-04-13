package edu.authcp.controller;

import edu.authcp.dto.ArticleDto;
import edu.authcp.dto.BlogDto;
import edu.authcp.service.ArticleService;
import edu.authcp.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class VisitorController {

    private final BlogService blogService;

    private final ArticleService articleService;

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDto>> showAllArticles(){
        return new ResponseEntity<>(articleService.findAllArticles(), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> showAllBlogs(){
        return new ResponseEntity<>(blogService.findAllBlogs(), HttpStatus.OK);
    }

}

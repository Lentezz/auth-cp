package edu.authcp.controller;

import edu.authcp.dto.ArticleDto;
import edu.authcp.dto.BlogDto;
import edu.authcp.service.ArticleService;
import edu.authcp.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    private final ArticleService articleService;

    @PostMapping("/create")
    public ResponseEntity<BlogDto> saveBlog(Principal principal, @RequestBody BlogDto blogDto){
        blogDto.setArticleList(new ArrayList<>());
        try {
            blogDto.setAuthor(principal.getName());
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(blogService.createBlog(blogDto, principal.getName()), HttpStatus.OK);
    }

    @PostMapping("/article/create")
    public ResponseEntity<ArticleDto> createArticle(Principal principal, @RequestBody ArticleDto articleDto){
        return new ResponseEntity<>(articleService.createArticle(articleDto, principal.getName()), HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<BlogDto> showMyArticles(Principal principal){
        return new ResponseEntity<>(blogService.showBlog(principal.getName()), HttpStatus.OK);
    }

}

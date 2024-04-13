package edu.authcp.controller;

import edu.authcp.dto.BlogDto;
import edu.authcp.entity.Blog;
import edu.authcp.repository.ArticleRepository;
import edu.authcp.repository.BlogRepository;
import edu.authcp.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @DeleteMapping("/deleteAllBlogs")
    public ResponseEntity<Void> deleteAllBlogs(){
        adminService.deleteAllBlogs();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("deleteArticle/{id}")
    public ResponseEntity<BlogDto> deleteArticleById(@PathVariable String id){

        return new ResponseEntity<>(adminService.deleteArticleById(id), HttpStatus.OK);
    }

}

package edu.authcp.service;

import edu.authcp.dto.BlogDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    void deleteAllBlogs();

    BlogDto deleteArticleById(String id);
}

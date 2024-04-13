package edu.authcp.service;

import edu.authcp.dto.BlogDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {

    BlogDto createBlog(BlogDto blogDto, String author);

    BlogDto showBlog(String name);

    List<BlogDto> findAllBlogs();
}

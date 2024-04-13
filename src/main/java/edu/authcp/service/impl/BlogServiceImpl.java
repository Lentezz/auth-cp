package edu.authcp.service.impl;

import edu.authcp.dto.ArticleDto;
import edu.authcp.dto.BlogDto;
import edu.authcp.entity.Blog;
import edu.authcp.exception.BlogNotFoundException;
import edu.authcp.repository.BlogRepository;
import edu.authcp.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    private static final ModelMapper modelMapper = new ModelMapper();


    @Override
    public BlogDto createBlog(BlogDto blogDto, String author) {
        Blog blog = blogRepository.findByAuthor(author).orElse(modelMapper.map(blogDto, Blog.class));
        return modelMapper.map(blogRepository.save(blog), BlogDto.class);
    }

    @Override
    public BlogDto showBlog(String author) {

        Blog blog = blogRepository.findByAuthor(author).orElseThrow(() ->
                new BlogNotFoundException(String.format("Blog with author '%s' not found.", author)));
        return modelMapper.map(blog, BlogDto.class);
    }

    @Override
    public List<BlogDto> findAllBlogs() {
        return blogRepository.findAll().stream()
                .map(x -> modelMapper.map(x, BlogDto.class))
                .collect(Collectors.toList());
    }
}

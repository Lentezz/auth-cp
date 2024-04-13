package edu.authcp.repository;

import edu.authcp.entity.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends MongoRepository<Blog, String> {

    Optional<Blog> findByAuthor(String author);
}

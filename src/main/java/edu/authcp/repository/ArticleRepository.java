package edu.authcp.repository;

import edu.authcp.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {
}

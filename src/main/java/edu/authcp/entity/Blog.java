package edu.authcp.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(value = "blogs")
public class Blog {

    @Id
    private String id;

    private String author;

    private List<Article> articleList;
}

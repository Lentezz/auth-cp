package edu.authcp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(value = "article")
public class Article {

    @Id
    private String id;

    private String author;

    private String content;

    private String articleType;

    private Date date;
}

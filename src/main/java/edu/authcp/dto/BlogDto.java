package edu.authcp.dto;

import edu.authcp.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {

    private String id;

    private String author;

    private List<Article> articleList;
}

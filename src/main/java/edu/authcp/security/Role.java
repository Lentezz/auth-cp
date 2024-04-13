package edu.authcp.security;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "roles")
public class Role {
    @Id
    private String id;

    private String name;
}

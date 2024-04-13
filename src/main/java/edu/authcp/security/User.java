package edu.authcp.security;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@Document(value = "users")
public class User {
    @Id
    private String id;

    private String username;

    private String password;

    private Collection<Role> roles;
}

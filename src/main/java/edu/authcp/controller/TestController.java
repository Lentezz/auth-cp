package edu.authcp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/unsecured")
    public String unsecuredData(){
        return "unsecured";
    }

    @GetMapping("/secured")
    public String securedData(){
        return "secured";
    }

    @GetMapping("/info")
    public String userData(Principal principal){
        return principal.getName();
    }


}

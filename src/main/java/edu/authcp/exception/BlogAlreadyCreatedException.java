package edu.authcp.exception;

public class BlogAlreadyCreatedException extends RuntimeException{

    public BlogAlreadyCreatedException(String message) {
        super(message);
    }
}

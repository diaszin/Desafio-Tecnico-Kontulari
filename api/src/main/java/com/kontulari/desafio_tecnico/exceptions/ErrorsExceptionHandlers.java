package com.kontulari.desafio_tecnico.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorsExceptionHandlers extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProfileNotFound.class)
    public ResponseEntity<DefaultHandlerResponse> githubProfileNotFound(ProfileNotFound e){
        DefaultHandlerResponse error = new DefaultHandlerResponse(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultHandlerResponse> githubProfileNotFound(){
        DefaultHandlerResponse error = new DefaultHandlerResponse("Erro interno no servidor !");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(RepositoriesNotFound.class)
    public ResponseEntity<DefaultHandlerResponse> githubRepositoriesNotFound(RepositoriesNotFound e){
        DefaultHandlerResponse error = new DefaultHandlerResponse(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(RepositoriesIsEmpty.class)
    public ResponseEntity<DefaultHandlerResponse> githubRepositoriesNotFound(RepositoriesIsEmpty e){
        DefaultHandlerResponse error = new DefaultHandlerResponse(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(RateLimitExceeded.class)
    public ResponseEntity<DefaultHandlerResponse> githubRateLimitExceeded(RateLimitExceeded e){
        DefaultHandlerResponse error = new DefaultHandlerResponse(e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}

package com.kontulari.desafio_tecnico.infra;

import com.kontulari.desafio_tecnico.exceptions.ProfileNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorsExceptionHandlers extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProfileNotFound.class)
    public ResponseEntity<DefaultHandlerException> githubProfileNotFound(ProfileNotFound e){
        DefaultHandlerException error = new DefaultHandlerException(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<DefaultHandlerException> githubProfileNotFound(){
        DefaultHandlerException error = new DefaultHandlerException("Erro interno no servidor !");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}

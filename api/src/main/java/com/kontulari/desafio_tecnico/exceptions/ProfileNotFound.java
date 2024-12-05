package com.kontulari.desafio_tecnico.exceptions;

public class ProfileNotFound extends RuntimeException{
    public ProfileNotFound(String notFoundUsername){
        super(String.format("O perfil '%s' não existe", notFoundUsername));
    }
}

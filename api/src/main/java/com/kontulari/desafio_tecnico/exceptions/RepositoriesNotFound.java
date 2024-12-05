package com.kontulari.desafio_tecnico.exceptions;

public class RepositoriesNotFound extends RuntimeException{
    public RepositoriesNotFound(){
        super("Nenhum repositório foi encontrado");
    }
}

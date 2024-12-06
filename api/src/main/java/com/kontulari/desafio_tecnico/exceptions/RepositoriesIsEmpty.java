package com.kontulari.desafio_tecnico.exceptions;

public class RepositoriesIsEmpty extends RuntimeException {
    public RepositoriesIsEmpty() {
        super("Esse usuário não tem repositórios");
    }
}

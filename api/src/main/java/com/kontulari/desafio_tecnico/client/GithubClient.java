package com.kontulari.desafio_tecnico.client;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GithubClient {
    private final RestTemplate client;


    GithubClient(){
        this.client = new RestTemplate();
    }

    public RestTemplate getClient() {
        return this.client;
    }
}

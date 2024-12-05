package com.kontulari.desafio_tecnico.service;

import com.kontulari.desafio_tecnico.client.GithubClient;
import com.kontulari.desafio_tecnico.entity.GithubProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
public class ProfileGithubService {

    @Autowired
    GithubClient githubClient;

    @Value("${github.api.url}")
    private String BASE_URL;

    public GithubProfile getProfile(String username){
        String endpoint = BASE_URL + "users/" + username;
        GithubProfile profile = githubClient.getClient().getForObject(endpoint, GithubProfile.class);

        return profile;
    }
}

package com.kontulari.desafio_tecnico.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kontulari.desafio_tecnico.client.GithubClient;
import com.kontulari.desafio_tecnico.entity.GithubProfile;
import com.kontulari.desafio_tecnico.entity.GithubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ProfileGithubService {

    @Autowired
    GithubClient githubClient;

    @Value("${github.api.url}")
    private String BASE_URL;

    public GithubProfile getProfile(String username) {
        String endpoint = BASE_URL + "users/" + username;
        GithubProfile profile = githubClient.getClient().getForObject(endpoint, GithubProfile.class);

        return profile;
    }

    public GithubRepository[] getRepositories(String username) {
        String endpoint = BASE_URL + "users/" + username + "/repos";

        ResponseEntity<GithubRepository[]> response = this.githubClient.getClient().getForEntity(endpoint, GithubRepository[].class);
        GithubRepository[] repositories = response.getBody();

        return repositories;
    }
}
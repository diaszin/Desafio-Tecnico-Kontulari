package com.kontulari.desafio_tecnico.service;

import com.kontulari.desafio_tecnico.client.GithubClient;
import com.kontulari.desafio_tecnico.entity.GithubProfile;
import com.kontulari.desafio_tecnico.entity.GithubRepository;
import com.kontulari.desafio_tecnico.exceptions.ProfileNotFound;
import com.kontulari.desafio_tecnico.exceptions.RepositoriesNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;


@Slf4j
@Service
public class ProfileGithubService {

    @Autowired
    GithubClient githubClient;

    @Value("${GITHUB_API}")
    private String BASE_URL;

    public GithubProfile getProfile(String username) {
        String endpoint = BASE_URL + "users/" + username;

        try{
            Optional<GithubProfile> profile = Optional.ofNullable(githubClient.getClient().getForObject(endpoint, GithubProfile.class));
            return profile.orElseThrow();
        }
        catch(HttpClientErrorException.NotFound e){
            throw new ProfileNotFound(username);
        }
        catch (Exception e){
            log.error(e.toString());
            log.error(e.getMessage());

            throw new RuntimeException(e);
        }

    }

    public GithubRepository[] getRepositories(String username) {
        String endpoint = BASE_URL + "users/" + username + "/repos";

        try{
            ResponseEntity<GithubRepository[]> response = this.githubClient.getClient().getForEntity(endpoint, GithubRepository[].class);
            GithubRepository[] repositories = response.getBody();

            return repositories;
        }
        catch (HttpClientErrorException.NotFound e){
            throw new RepositoriesNotFound();
        }
        catch (Exception e){
            log.error(e.toString());
            log.error(e.getMessage());

            throw new RuntimeException(e);
        }
    }
}
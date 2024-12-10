package com.kontulari.desafio_tecnico.service;

import com.kontulari.desafio_tecnico.client.GithubClient;
import com.kontulari.desafio_tecnico.entity.GithubRepository;
import com.kontulari.desafio_tecnico.exceptions.RepositoriesIsEmpty;
import com.kontulari.desafio_tecnico.exceptions.RepositoriesNotFound;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Log4j2
@Service
public class RepositoryGithubService {
    @Autowired
    GithubClient githubClient;

    @Value("${GITHUB_API:https://api.github.com/}")
    private String BASE_URL;

    public GithubRepository[] getRepositories(String username) {
        String endpoint = BASE_URL + "users/" + username + "/repos";

        try{
            ResponseEntity<GithubRepository[]> response = this.githubClient.getClient().getForEntity(endpoint, GithubRepository[].class);
            GithubRepository[] repositories = response.getBody();

            if (repositories == null || repositories.length == 0){
                throw new RepositoriesIsEmpty();
            }

            return repositories;
        }
        catch (HttpClientErrorException.NotFound e){
            throw new RepositoriesNotFound();
        }
        catch (RepositoriesIsEmpty e){
            throw e;
        }
        catch (Exception e){
            log.error(e.toString());
            log.error(e.getMessage());

            throw new RuntimeException(e);
        }
    }
}

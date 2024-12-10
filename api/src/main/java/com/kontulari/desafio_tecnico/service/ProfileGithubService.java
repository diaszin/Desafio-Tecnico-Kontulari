package com.kontulari.desafio_tecnico.service;

import com.kontulari.desafio_tecnico.client.GithubClient;
import com.kontulari.desafio_tecnico.entity.GithubProfile;
import com.kontulari.desafio_tecnico.entity.GithubRepository;
import com.kontulari.desafio_tecnico.exceptions.ProfileNotFound;
import com.kontulari.desafio_tecnico.exceptions.RateLimitExceeded;
import com.kontulari.desafio_tecnico.exceptions.RepositoriesIsEmpty;
import com.kontulari.desafio_tecnico.exceptions.RepositoriesNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


@Slf4j
@Service
public class ProfileGithubService {

    @Autowired
    GithubClient githubClient;

    @Value("${GITHUB_API:https://api.github.com/}")
    private String BASE_URL;

    public GithubProfile getProfile(String username) {
        String endpoint = BASE_URL + "users/" + username;

        try{
            ResponseEntity<GithubProfile> response = githubClient.getClient().getForEntity(endpoint, GithubProfile.class);
            HttpHeaders responseHeader = response.getHeaders();
            Optional<GithubProfile> profile = Optional.ofNullable(response.getBody());

            String rateLimitRemainingResponse = responseHeader.getFirst("X-RateLimit-Remaining");
            String rateLimitTimestampResponse = responseHeader.getFirst("X-RateLimit-Reset");

            if(rateLimitRemainingResponse != null && rateLimitTimestampResponse != null){
                // O valor restante tem que ser maior que número de requisições
                int rateLimitRemaining = Integer.parseInt(rateLimitRemainingResponse);
                long rateLimitTimestamp = Long.parseLong(rateLimitTimestampResponse);

                Date timestampDate = new Date(rateLimitTimestamp);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String resetDate = simpleDateFormat.format(timestampDate);

                if(rateLimitRemaining <= 1){
                    throw new RateLimitExceeded(resetDate);
                }
            }


            return profile.orElseThrow();
        } catch (RateLimitExceeded e) {
            throw e;
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
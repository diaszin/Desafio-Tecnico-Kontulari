package com.kontulari.desafio_tecnico.controller;

import com.kontulari.desafio_tecnico.entity.GithubProfile;
import com.kontulari.desafio_tecnico.entity.GithubRepository;
import com.kontulari.desafio_tecnico.service.ProfileGithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileGithubService profileGithubService;

    @GetMapping("/{username}/user")
    public ResponseEntity<GithubProfile> getProfile(@PathVariable String username){
        GithubProfile profile = this.profileGithubService.getProfile(username);

        return ResponseEntity.ok(profile);
    }

    @GetMapping("/{username}/repositories")
    public ResponseEntity<GithubRepository[]> getRepositories(@PathVariable String username){
        GithubRepository[] repositories = this.profileGithubService.getRepositories(username);

        return ResponseEntity.ok(repositories);
    }
}

package com.kontulari.desafio_tecnico.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GithubProfile {
    private String login;
    private String html_url;
    private int public_repos;
    private int followers;
    private int following;
    private Date created_at;
}



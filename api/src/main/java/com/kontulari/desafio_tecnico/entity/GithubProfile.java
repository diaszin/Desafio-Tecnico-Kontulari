package com.kontulari.desafio_tecnico.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
public class GithubProfile {
    private String login;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("public_repos")
    private int quantityRepos;
    private int followers;
    private int following;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("avatar_url")
    private String avatarUrl;

    public String getCreatedAt() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = simpleDateFormat.format(this.createdAt);

        return formattedDate;
    }
}



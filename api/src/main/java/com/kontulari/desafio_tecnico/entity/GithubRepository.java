package com.kontulari.desafio_tecnico.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.text.SimpleDateFormat;


@Data
@Builder
public class GithubRepository {
    private int id;
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("html_url")
    private String htmlUrl;
    private String description;
    @JsonProperty("created_at")
    private Date createdAt;

    public String getCreatedAt() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = simpleDateFormat.format(this.createdAt);

        return formattedDate;
    }
}

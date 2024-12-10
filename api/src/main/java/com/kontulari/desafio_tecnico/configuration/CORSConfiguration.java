package com.kontulari.desafio_tecnico.configuration;


import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CORSConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String ACCEPTED_URL_CONNECTION = System.getenv().get("ACCEPTED_URL_CONNECTION");
        registry.addMapping("/profile/*")
                .allowedOrigins(ACCEPTED_URL_CONNECTION)
                .allowedMethods("GET", "HEAD");
    }
}

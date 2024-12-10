package com.kontulari.desafio_tecnico.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RateLimitExceeded extends RuntimeException {
    public RateLimitExceeded(String resetDate) {
        super(String.format("Limite de requisições excedida. Retorne em: %s", resetDate));
    }
}

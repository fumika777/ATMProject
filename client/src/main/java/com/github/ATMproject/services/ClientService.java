package com.github.ATMproject.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;


@Service
public class ClientService {
    private WebClient webClient;
    public ClientService(){
        this.webClient= WebClient.create("http://localhost:8080");
    }

    public Mono<String> checkPin (String cardNumber, int PIN) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/login")
                        .queryParam("cardNumber", cardNumber)
                        .queryParam("PIN",PIN)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? Mono.empty() : Mono.error(ex));
    }

    public Mono<String> getBalance (String cardNumber) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/getBalance")
                        .queryParam("cardNumber", cardNumber)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? Mono.empty() : Mono.error(ex));
    }

    public Mono<String> logout () {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/logout")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? Mono.empty() : Mono.error(ex));
    }
}

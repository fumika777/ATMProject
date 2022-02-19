package com.github.ATMproject.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;


@Service
public class ClientService {
    private static WebClient webClient;
    public ClientService(){
        this.webClient= WebClient.create("http://localhost:8080");
    }
    public ClientService(String baseURL){
        this.webClient= WebClient.create(baseURL);
    }

    public static Mono<String> checkPin(String cardNumber, int PIN) {
        return webClient.get()
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

    public static Mono<String> getBalance(String cardNumber) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/getBalance")
                        .queryParam("cardNumber", cardNumber)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? Mono.empty() : Mono.error(ex));
    }

    public static Mono<String> logout() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/logout")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? Mono.empty() : Mono.error(ex));
    }
}

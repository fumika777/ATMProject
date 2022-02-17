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
        System.out.println("Дергается метод");
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/loginClient")
                        .queryParam("cardNumber", cardNumber)
                        .queryParam("PIN",PIN)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? Mono.empty() : Mono.error(ex));
    }
}

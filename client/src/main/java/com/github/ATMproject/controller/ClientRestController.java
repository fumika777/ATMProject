package com.github.ATMproject.controller;
import com.github.ATMproject.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class ClientRestController {
    ClientService clientService;
    @GetMapping(value = "/login")
//    public boolean loginSystem(@RequestParam(value = "cardNumber") String cardNumber,@RequestParam(value = "PIN") int PIN){
    public Mono<String> loginSystem(@RequestParam(value = "cardNumber") String cardNumber, @RequestParam(value = "PIN") int PIN){
        System.out.println("Дергается контроллер");
        return clientService.checkPin(cardNumber, PIN);
    }
}

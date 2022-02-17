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

    /**
     * Метод осуществляющмй логинство в систему
     * @param cardNumber Номер карты
     * @param PIN Пин-код
     * @return Результат авторизации
     */
    @GetMapping(value = "/login")
    public Mono<String> loginSystem(@RequestParam(value = "cardNumber") String cardNumber, @RequestParam(value = "PIN") int PIN){
        return clientService.checkPin(cardNumber, PIN);
    }

    /**
     * Метод получения баланса по номеру карты
     * @param cardNumber номер карты
     * @return Объект баланса
     */
    @GetMapping(value = "/getBalance")
    public Mono<String> getBalance(@RequestParam(value = "cardNumber") String cardNumber){
        return clientService.getBalance(cardNumber);
    }

    /**
     * Метод отвечающий за выход из системы
     */
    @GetMapping(value = "/logout")
    public Mono<String> logout(){
        return clientService.logout();
    }
}

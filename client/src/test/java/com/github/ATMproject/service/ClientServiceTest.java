package com.github.ATMproject.service;

import com.github.ATMproject.services.ClientService;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientServiceTest {

    public static MockWebServer mockBackEnd;
    public ClientService clientService;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @BeforeEach
    void initialize() {
        String baseUrl = String.format("http://localhost:%s",
                mockBackEnd.getPort());
        clientService = new ClientService(baseUrl);
    }
    @Test
    void checkPin() throws Exception {
        boolean mockLoginResponse = true;
        mockBackEnd.enqueue(new MockResponse()
                .setBody(String.valueOf(mockLoginResponse))
                .addHeader("Content-Type", "application/json")
                );

        Mono<String> responseMono = ClientService.checkPin("4000001234567899",1012);

        StepVerifier.create(responseMono)
                .expectNext(String.valueOf(mockLoginResponse))
                .expectComplete()
                .verify();

        RecordedRequest recordedRequest = mockBackEnd.takeRequest();

        assertEquals("GET", recordedRequest.getMethod());
        assertEquals("/login?cardNumber=4000001234567899&PIN=1012", recordedRequest.getPath());
    }

    @Test
    void getBalance() throws Exception {
        String mockResponse = "{ \"amount\":0, \"currency\":\"RUR\", \"message\":\"\"}";
        mockBackEnd.enqueue(new MockResponse()
                .setBody(mockResponse)
                .addHeader("Content-Type", "application/json")
        );
        Mono<String> responseMono = ClientService.getBalance("4000001234567899");

        StepVerifier.create(responseMono)
                .expectNext(mockResponse)
                .expectComplete()
                .verify();

        RecordedRequest recordedRequest = mockBackEnd.takeRequest();

        assertEquals("GET", recordedRequest.getMethod());
        assertEquals("/getBalance?cardNumber=4000001234567899", recordedRequest.getPath());
    }

    @Test
    void logout() throws Exception {
        String mockResponse = "Выход из системы выполнен успешно";
        mockBackEnd.enqueue(new MockResponse()
                .setBody(mockResponse)
                .addHeader("Content-Type", "application/json")
        );
        Mono<String> responseMono = ClientService.logout();

        StepVerifier.create(responseMono)
                .expectNext(mockResponse)
                .expectComplete()
                .verify();

        RecordedRequest recordedRequest = mockBackEnd.takeRequest();

        assertEquals("GET", recordedRequest.getMethod());
        assertEquals("/logout", recordedRequest.getPath());
    }


    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }
}
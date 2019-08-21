package com.lock.client.lockclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {

        String url = "http://localhost:8080/product";

        Stream.iterate(1, n -> n + 1)
                .limit(100)
                .map(x -> String.format("client_%s", x))
                .parallel()
                .forEach(x -> {
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("client_name", x);
                    HttpEntity entity = new HttpEntity(headers);
                    try {
                        ResponseEntity<Void> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, Void.class);
                        System.out.printf("Client: %s | Status: %s\n", x, exchange.getStatusCode());
                    } catch (RestClientResponseException e) {
                        System.out.printf("Client: %s | Status: %s\n", x, e.getRawStatusCode());
                    }
                });

    }
}
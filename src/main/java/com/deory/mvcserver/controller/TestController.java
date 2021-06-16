package com.deory.mvcserver.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class TestController {

    private static final RestTemplate client = new RestTemplate();
    private static URI uri;

    static {
        try {
            uri = new URI("http://localhost:8080/test");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/**")
    public String testPost(@RequestBody String body) {
        return client.exchange(uri, HttpMethod.POST, new HttpEntity<>(body), String.class).getBody();
    }

    @PutMapping("/**")
    public String testPut(@RequestBody String body) {
        return client.exchange(uri, HttpMethod.PUT, new HttpEntity<>(body), String.class).getBody();
    }
}

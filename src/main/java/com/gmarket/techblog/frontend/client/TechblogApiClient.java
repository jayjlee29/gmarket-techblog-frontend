package com.gmarket.techblog.frontend.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URLEncoder;

@Slf4j
@Component
public class TechblogApiClient {

    @Value("${api.host}")
    private String host;
    private WebClient webClient = null;


    @PostConstruct
    void init() {
        webClient = WebClient.builder().build();
    }

    public Flux<String> getSessionIds() {
        String url = host + "/sessions";
        URI uri = URI.create(url);
        return webClient.get().uri(uri)
                .retrieve().bodyToFlux(String.class);
    }

    public Mono<Boolean> publish(String topic, String payload){

        String url = host + "/publish/" + topic + "?payload=" +encoding(payload);
        URI uri = URI.create(url);
        return webClient.get().uri(uri)
                .retrieve().bodyToMono(Boolean.class);
    }

    private String encoding(String payload) {
        try{
            return URLEncoder.encode(payload, "UTF-8");
        } catch(Exception e) {
            log.error("error uri encoding ", e);
        }

        return "";
    }

    public Flux<String> getData(String topic){

        String url = host + "/data/" + topic;
        URI uri = URI.create(url);
        return webClient.get().uri(uri)
                .retrieve().bodyToFlux(String.class);
    }

}

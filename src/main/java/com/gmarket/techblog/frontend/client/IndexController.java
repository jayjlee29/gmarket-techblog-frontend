package com.gmarket.techblog.frontend.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class IndexController {
    @Autowired
    TechblogApiClient apiClient;

    @GetMapping("/")
    public Mono<String> index(Model model) {
        model.addAttribute("data", "chating webflux client");

        return Mono.just("/index");
    }

    @ResponseBody
    @PostMapping("/publish")
    public Mono<Boolean> publish(@RequestBody PublishRequest req) {

        return apiClient.publish("serverTopic", req.getPayload());
    }


    @ResponseBody
    @GetMapping("/data/{key}")
    public Flux<String> getData(@PathVariable("key") String key) {

        return apiClient.getData(key);
    }
}

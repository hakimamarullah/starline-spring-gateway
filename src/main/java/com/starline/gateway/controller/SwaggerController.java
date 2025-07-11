package com.starline.gateway.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SwaggerController {

    private final DiscoveryClient discoveryClient;

    public SwaggerController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/swagger-config")
    public Map<String, Object> swaggerConfig() {
        List<Map<String, String>> urls = discoveryClient.getServices().stream()
                .map(name -> {
                    String url = "/" + name.toLowerCase() + "/v3/api-docs";
                    if (name.toLowerCase().contains("whatsapp")) {
                        url = "/" + name.toLowerCase() + "/swagger/json";
                    }
                    return Map.of("name", name, "url", url);
                })
                .toList();

        return Map.of("urls", urls);
    }
}

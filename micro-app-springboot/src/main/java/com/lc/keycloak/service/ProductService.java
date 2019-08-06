package com.lc.keycloak.service;

import java.util.Arrays;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    @Autowired
    private KeycloakRestTemplate template;

    @NotNull
    @Value("${product.service.url}")
    private String endpoint;

    public List<String> getProducts() {
        ResponseEntity<String[]> response = template.getForEntity(endpoint, String[].class);
        return Arrays.asList(response.getBody());
    }

}

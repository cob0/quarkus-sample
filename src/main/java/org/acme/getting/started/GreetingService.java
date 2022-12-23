package org.acme.getting.started;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
public class GreetingService {

    @Inject
    @Named("whateverRestTemplate")
    RestTemplate restTemplate;

    public String greeting(String name) {
        ResponseEntity<String> joke = restTemplate.getForEntity("https://api.chucknorris.io/jokes/random", String.class);
        return joke.getBody();
    }

}

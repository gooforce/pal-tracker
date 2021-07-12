package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Value("${welcome.message}")
    String message;

    public WelcomeController() {
    }

    public WelcomeController(String msg) {
        message=msg;
    }

    @GetMapping("/")
    public String sayHello() {
        return message;
    }
}
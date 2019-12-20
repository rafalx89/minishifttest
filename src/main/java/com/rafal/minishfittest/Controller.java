package com.rafal.minishfittest;

import com.rafal.minishfittest.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class Controller {

    private static final String template = "Hello, %s!";

    private static final String RANDOM_NAME = "RANDOMNAME_" + Math.random();

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        return new Greeting(counter.incrementAndGet() + "", String.format(template, name) +" " + RANDOM_NAME);
    }
}

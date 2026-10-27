package com.myself.practicing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myself.practicing.domain.models.Greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;


@RestController 
@RequestMapping("/api/v1")
public class PracticeController {

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting Greeting(@RequestParam(defaultValue = "World") String name) 
    {
        return new Greeting(counter.incrementAndGet(), template.formatted(name));
    }

}
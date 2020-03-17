package com.lqs.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getHello(String name) {
        return "Hello world " + name;
    }
}

package com.lqs.demo.web;

import com.lqs.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @PostMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name) {
        return helloService.getHello(name);
    }
}

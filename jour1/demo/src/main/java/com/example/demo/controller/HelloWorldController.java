package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${profiles.active}")
    public String activeProfile;

    @Value("${profiles.dev.message}")
    public String devMessage;

    @Value("${profiles.prod.message}")
    public String prodMessage;

    @Value("${profiles.${profiles.active}.message}")
    String msg;

    @GetMapping("/")
    public String Hello(){
        String greetingMessage = "Default Greeting";

        return msg + "HelloWorld";
//        if ("dev".equals(activeProfile)) {
//            greetingMessage = devMessage;
//        } else if ("prod".equals(activeProfile)) {
//            greetingMessage = prodMessage;
//        }
//        return "Hello World " + greetingMessage;
    }
}

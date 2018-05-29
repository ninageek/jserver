package com.ninageek.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class TestJserverController {

    @RequestMapping(value = "/test-jserver", method = RequestMethod.GET)
    public String testJserver(){
        return "Java server is working!";
    }
}

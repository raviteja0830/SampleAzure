package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
public class HelloController {
	
	@ApiOperation(value = "Say Hai")
	@GetMapping(value = "/hai")
    public String index() {
        return "Hai Dude!";
    }
    
}
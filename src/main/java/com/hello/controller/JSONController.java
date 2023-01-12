package com.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class JSONController {

    @PostMapping(path="/json")
    public String Json(@RequestBody HashMap<String,Object> param){
        System.out.println("param "+ param);
        return param.toString();
    }
}

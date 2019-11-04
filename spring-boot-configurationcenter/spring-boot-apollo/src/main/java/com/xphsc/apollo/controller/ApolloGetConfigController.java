package com.xphsc.apollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApolloGetConfigController {
    @Value("${baidu.url:default}")
    private String value;

    @GetMapping("/getConfig")
    public String getConfig(){
        return value;
    }

}

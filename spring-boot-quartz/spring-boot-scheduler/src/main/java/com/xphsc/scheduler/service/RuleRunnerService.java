package com.xphsc.scheduler.service;

import org.springframework.stereotype.Service;

@Service
public class RuleRunnerService {
    public void execute(){
    }
    public void run(){
        System.out.println("this is my simple quartz job!");
    }
}



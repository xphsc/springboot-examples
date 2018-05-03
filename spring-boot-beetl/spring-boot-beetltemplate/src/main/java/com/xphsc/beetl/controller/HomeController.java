package com.xphsc.beetl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Controller
@RequestMapping(value = "home")
public class HomeController {
    @GetMapping
    public String home(Model model){
        model.addAttribute("hello","hello world");
        return "index";
    }
}

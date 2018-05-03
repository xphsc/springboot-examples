package com.xphsc.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Controller
public class ViewController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","ª∂”≠Ω¯»Îindex“≥√Ê");
        return "index";
    }
}

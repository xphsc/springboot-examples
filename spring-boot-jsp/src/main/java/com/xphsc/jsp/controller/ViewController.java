package com.xphsc.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Controller
public class ViewController {

    public String html(Model model){
        model.addAttribute("code",111);
        return "/view";
    }
}

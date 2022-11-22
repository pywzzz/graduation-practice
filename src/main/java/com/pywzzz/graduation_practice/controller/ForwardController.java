package com.pywzzz.graduation_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forward")
public class ForwardController {
    @RequestMapping("/page1")
    public String page1() {
        return "page1";
    }

    @RequestMapping("/page2")
    public String page2() {
        return "page2";
    }
}

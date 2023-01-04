package com.pywzzz.graduation_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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

    @RequestMapping("/toDept")
    public String toDept() {
        return "dept";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toHome")
    public String toHome(){
        return "home";
    }

    @RequestMapping("/toRole")
    public String toRole(){
        return "role";
    }

    @RequestMapping("/toLogout")
    public String toLogout(HttpSession session){
        //销毁session数据
        session.invalidate();
        return "login";
    }

    @RequestMapping("/toEmp")
    public String toEmp(){
        return "emp";
    }

    @RequestMapping("/toTestLogin")
    public String toTestLogin(){
        return "test_login";
    }
}

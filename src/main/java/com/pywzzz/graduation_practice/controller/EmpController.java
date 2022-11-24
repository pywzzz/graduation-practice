package com.pywzzz.graduation_practice.controller;

import com.pywzzz.graduation_practice.entity.Emp;
import com.pywzzz.graduation_practice.service.IEmpService;
import com.pywzzz.graduation_practice.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/emp")
public class EmpController {
    //定义业务层对象
    @Autowired
    private IEmpService empService;
    //定义服务器会话对象，用于存储登陆成功的用户信息
    @Autowired
    private HttpSession session;

    @RequestMapping("/login")
    public Result login(String userName,String password){
        //调用业务层对象，完成登陆查询
        Emp emp = empService.login(userName, password);
        if(emp==null){
            return new Result(500,"用户名或密码错误",0,null);
        }
        if(emp.getStatus().equals("1")){
            return new Result(500,"该员工已经离职",0,null);
        }
        //登陆成功，就将登陆员工数据存入session
        session.setAttribute("loginEmp",emp);

        return new  Result(0,"success",1,emp);
    }
}

package com.pywzzz.graduation_practice.controller;

import com.pywzzz.graduation_practice.entity.Emp;
import com.pywzzz.graduation_practice.service.IEmpService;
import com.pywzzz.graduation_practice.util.Result;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author: hy
 * @create: 2022-11-24 09:54:50
 */
@RestController
@Slf4j
@RequestMapping("/emp")
public class EmpController {
    //定义业务层对象
    @Autowired
    private IEmpService empService;
    //定义服务器会话对象，用于存储登陆成功的用户信息
    @Autowired
    private HttpSession session;

    @PostMapping("/login")
    public Result login(String userName,String password){
        log.info("userName:"+userName);
        log.info("password:"+password);

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

    @GetMapping("/list")
    public Result list(Integer page,Integer limit,String searchEmpName){
        //debug<info<warn<error<fatal
        log.info("=====searchEmpName:======"+searchEmpName);
        //调用业务层进行分页查询
        PageInfo<Emp> pi = empService.listByPage(page, limit, searchEmpName);
        return new Result(0,"success",pi.getTotal(),pi.getList());
    }

    @PostMapping("/add")
    public Result add(Emp emp){
        log.info(emp.toString());

        //设置部门的创建人(当前登陆的员工)和创建时间
        Emp loginEmp = (Emp)session.getAttribute("loginEmp");
        emp.setCreateBy(loginEmp.getEmpName());
        emp.setCreateTime(new Date());

        int count = empService.add(emp);
        return new Result(0,"",1,count);
    }
}

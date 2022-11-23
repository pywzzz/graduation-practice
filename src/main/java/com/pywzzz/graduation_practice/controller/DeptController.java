package com.pywzzz.graduation_practice.controller;

import com.pywzzz.graduation_practice.entity.Dept;
import com.pywzzz.graduation_practice.service.IDeptService;
import com.pywzzz.graduation_practice.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private IDeptService deptService;

    @RequestMapping("/list")
    public Result list(){
        //code msg count data
        List<Dept> depts = deptService.list();
        //返回封装后的结果数据
        return new Result(0,"",depts.size(),depts);
    }

}

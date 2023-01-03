package com.pywzzz.graduation_practice.controller;

import com.pywzzz.graduation_practice.entity.Tester;
import com.pywzzz.graduation_practice.service.ITesterService;
import com.pywzzz.graduation_practice.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * @author: hy
 * @create: 2023-01-03 11:36:36
 */
@Controller
@RequestMapping("/tester")
public class TesterController {
    //定义业务层对象
    @Autowired
    private ITesterService testerService;
    /**
     * 用户测试入口
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result login(Tester tester){
        //先根据手机号，查询测试用户表中，是否有记录
        QueryWrapper<Tester> qw = new QueryWrapper<>();
        qw.eq("phone",tester.getPhone());
        List<Tester> testerList = testerService.list(qw);
        //如果没有该手机号的记录，说明之前没有测试过
        if(testerList.size()==0){
            //将该测试者的信息，存储到测试用户表中
            testerService.save(tester);
            return new Result(0,"还没有测试过",1,tester);
        }
        //如果该手机号已经测试过，则直接返回测试者信息
        return new Result(1,"已经测试过",1,testerList.get(0));
    }
}

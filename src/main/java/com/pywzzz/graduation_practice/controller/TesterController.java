package com.pywzzz.graduation_practice.controller;

import com.pywzzz.graduation_practice.entity.Question;
import com.pywzzz.graduation_practice.entity.TestResult;
import com.pywzzz.graduation_practice.entity.Tester;
import com.pywzzz.graduation_practice.entity.TesterVo;
import com.pywzzz.graduation_practice.service.IQuestionService;
import com.pywzzz.graduation_practice.service.ITestResultService;
import com.pywzzz.graduation_practice.service.ITesterService;
import com.pywzzz.graduation_practice.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
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
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private ITestResultService testResultService;
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
            //设置做题者的做题时间
            tester.setCreateTime(new Date());
            //将该测试者的信息，存储到测试用户表中
            testerService.save(tester);
            return new Result(0,"还没有测试过",1,tester);
        }
        //如果该手机号已经测试过，则直接返回测试者信息
        return new Result(1,"已经测试过",1,testerList.get(0));
    }

    @RequestMapping("/listQuestion")
    public String listQuestion(Model model,Integer testerId){
        //查询题目列表
        List<Question> questionList = questionService.list();
        //将题目列表数据存储到model中，带到页面进行渲染
        model.addAttribute("questionList",questionList);
        //将测试者的编号也存储到model中，带到页面上
        model.addAttribute("testerId",testerId);
        //跳转到题目列表页面
        return "test_question";
    }

    @RequestMapping("/saveResult")
    @ResponseBody //响应json字符串回传给浏览器
    public Result saveResult(@RequestBody List<TestResult> resultList){
        //@RequestBody:将客户端传入的json字符串，映射到对象上
        //System.out.println(resultList);
        //将客户端传入的做题结果，批量保存到数据库中
        testResultService.saveBatch(resultList);
        //修改做题者的状态，将做题者status改为1
        //构建修改表达式对象
        UpdateWrapper uw = new UpdateWrapper();
        uw.set("status","1"); //将状态值修改为1
        uw.eq("id",resultList.get(0).getTesterId()); //更新条件
        testerService.update(uw); //执行更新测试者
        //向前台返回执行结果
        return new Result(0,"成功",1L,resultList.get(0).getTesterId());
    }

    /**
     * 根据测试者编号，跳转到数据显示页面
     * @param testerId
     * @return
     */
    @RequestMapping("/show")
    public String show(Model model, Integer testerId){
        model.addAttribute("testerId",testerId);
        //跳转页面
        return "test_show";
    }

    @RequestMapping("/testerData")
    @ResponseBody
    public Result testerData(Integer testerId){
        //根据测试者编号，查询测试者数据
        TesterVo testerVo =  testerService.getById(testerId);
        return new Result(0,"success",1,testerVo);
    }
}
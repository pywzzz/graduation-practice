package com.pywzzz.graduation_practice.controller;

import com.pywzzz.graduation_practice.entity.Question;
import com.pywzzz.graduation_practice.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: hy
 * @create: 2023-01-03 09:22:15
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    //定义业务层对象
    @Autowired
    private IQuestionService questionService;

    @RequestMapping("/list")
    public String list(Model model){
        //使用题目业务层对象查询题目数据
        List<Question> questionList = questionService.list();
        System.out.println(questionList);
        //将查询存储到Model中，带到页面上
        model.addAttribute("questionList",questionList);
        //跳转到题目页面
        return "question";
    }

}

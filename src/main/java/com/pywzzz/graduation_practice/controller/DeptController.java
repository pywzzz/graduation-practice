package com.pywzzz.graduation_practice.controller;

import com.pywzzz.graduation_practice.entity.Dept;
import com.pywzzz.graduation_practice.entity.Emp;
import com.pywzzz.graduation_practice.service.IDeptService;
import com.pywzzz.graduation_practice.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author: hy
 * @create: 2022-11-23 08:39:49
 * 部门控制器
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    //定义业务层对象
    @Autowired
    private IDeptService deptService;
    @Autowired
    private HttpSession session;

    /**
     * 查询所有部门
     * @return 部门列表
     */
    @RequestMapping("/list")
    public Result list(){
        //code msg count data
        List<Dept> depts = deptService.list();
        //返回封装后的结果数据
        return new Result(0,"",depts.size(),depts);
    }

    @RequestMapping("/add")
    public Result add(Dept dept){
        //设置部门的创建人(当前登陆的员工)和创建时间
        Emp emp = (Emp)session.getAttribute("loginEmp");
        dept.setCreateBy(emp.getEmpName());
        dept.setCreateTime(new Date());

        //调用mp的保存方法，并接收返回的结果
        boolean flag = deptService.save(dept);
        //将本次处理的结果返回给前端
        return new Result(0,"success",1,flag);
    }

    //物理删除
    @RequestMapping("/delete")
    public Result delete(Integer deptId){
        boolean flag = deptService.removeById(deptId);
        return new Result(0,"success",1,flag);
    }
}
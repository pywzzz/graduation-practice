package com.pywzzz.graduation_practice.controller;

import com.pywzzz.graduation_practice.entity.Dept;
import com.pywzzz.graduation_practice.entity.Emp;
import com.pywzzz.graduation_practice.service.IDeptService;
import com.pywzzz.graduation_practice.util.Result;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageInfo;
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
    public Result list(Integer page,Integer limit,String searchDeptName){
        //code msg count data
        //List<Dept> depts = deptService.list();
        PageInfo<Dept> pi = deptService.listByPage(page, limit,searchDeptName);
        System.out.println(pi);
        //返回封装后的结果数据
        return new Result(0,"",pi.getTotal(),pi.getList());
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

    @RequestMapping("/update")
    public Result update(Dept dept){
        //设置部门的修改人(当前登陆的员工)和修改时间
        Emp emp = (Emp)session.getAttribute("loginEmp");
        dept.setUpdateBy(emp.getEmpName());
        dept.setUpdateTime(new Date());
        //调用修改处理
        boolean flag = deptService.updateById(dept);
        return new Result(0,"success",1,flag);
    }

    //删除
    @RequestMapping("/delete")
    public Result delete(Integer deptId){
        //物理删除
//        boolean flag = deptService.removeById(deptId);
//        return new Result(0,"success",1,flag);

        //逻辑删除
        UpdateWrapper uw=new UpdateWrapper();
        //更新那个记录,指定更新条件
        uw.eq("dept_id",deptId);
        //更新哪个列
        uw.set("delete_flag",1);
        //设置更新人
        Emp emp = (Emp)session.getAttribute("loginEmp");
        uw.set("update_by",emp.getEmpName());
        //设置更新时间
        uw.set("update_time",new Date());
        //根据设置，更新部门表
        boolean flag = deptService.update(uw);
        return new Result(0,"success",1,flag);
    }
}

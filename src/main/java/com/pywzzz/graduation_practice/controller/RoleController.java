package com.pywzzz.graduation_practice.controller;

import com.pywzzz.graduation_practice.entity.Emp;
import com.pywzzz.graduation_practice.entity.Role;
import com.pywzzz.graduation_practice.service.IRoleService;
import com.pywzzz.graduation_practice.util.Result;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author: hy
 * @create: 2022-11-23 11:47:16
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    //定义业务对象
    @Autowired
    private IRoleService roleService;
    @Autowired
    private HttpSession session;

    /**
     * 查询数据列表
     * @return
     */
    //@RequestMapping(value = "/list",method = RequestMethod.GET)
    @GetMapping("/list")
    public Result list(Integer page,Integer limit,String searchRoleName){
        PageInfo<Role> pi = roleService.listByPage(page, limit, searchRoleName);
        return new Result(0,"",pi.getTotal(),pi.getList());
    }

    /**
     * 获取所有角色数据
     * @return
     */
    @GetMapping("/listAll")
    public Result listAll(){
        List<Role> roleList = roleService.list();
        return new Result(0,"",roleList.size(),roleList);
    }

    //@RequestMapping("/add")
    @PostMapping("/add")
    public Result add(Role role){
        //设置创建人
        Emp emp =  (Emp)session.getAttribute("loginEmp");
        role.setCreateBy(emp.getEmpName());
        role.setCreateTime(new Date());

        //保存角色数据
        boolean flag = roleService.save(role);
        if(flag) {
            //返回添加成功的信息
            return new Result(0, "success", 1, flag);
        }
        //返回保存失败的信息
        return new Result(500,"fail",1,flag);
    }

    @PostMapping("/update")
    public Result update(Role role){
        //设置更新人
        Emp emp =  (Emp)session.getAttribute("loginEmp");
        role.setUpdateBy(emp.getEmpName());
        role.setUpdateTime(new Date());
        //调用业务层方法，完成实体更新
        boolean flag = roleService.updateById(role);
        if(flag){
            return new Result(0,"success",1,flag);
        }
        return new Result(500,"fail",1,flag);
    }

    @DeleteMapping("/delete")
    public Result delete(Integer roleId){
        //设置更新人
        Emp emp =  (Emp)session.getAttribute("loginEmp");
        //逻辑删除，使用修改包装器构建要修改的角色和更新的字段
        UpdateWrapper uw=new UpdateWrapper();
        //设置要修改的角色id
        uw.eq("role_id",roleId);
        //设置要修改的字段
        uw.set("delete_flag",1);
        //设置修改人
        uw.set("update_by",emp.getEmpName());
        //设置修改时间
        uw.set("update_time",new Date());
        //调用业务层完成修改操作
        boolean flag = roleService.update(uw);
        if(flag){
            return new Result(0,"success",1,flag);
        }
        return new Result(500,"fail",1,flag);
    }
}

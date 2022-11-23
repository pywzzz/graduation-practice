package com.pywzzz.graduation_practice.controller;

import com.pywzzz.graduation_practice.entity.Role;
import com.pywzzz.graduation_practice.service.IRoleService;
import com.pywzzz.graduation_practice.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 查询数据列表
     * @return
     */
    @RequestMapping("/list")
    public Result list(){
        List<Role> roles = roleService.list();
        return new Result(0,"",roles.size(),roles);
    }
}

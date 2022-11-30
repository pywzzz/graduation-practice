package com.pywzzz.graduation_practice.service;

import com.pywzzz.graduation_practice.entity.Emp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

public interface IEmpService extends IService<Emp> {
    //员工登陆
    Emp login(String userName,String password);
    //根据条件分页查询数据
    PageInfo<Emp> listByPage(Integer page,Integer limit,String empName);
    //添加员工
    int add(Emp emp);
}


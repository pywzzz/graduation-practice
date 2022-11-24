package com.pywzzz.graduation_practice.service;

import com.pywzzz.graduation_practice.entity.Emp;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IEmpService extends IService<Emp> {
    //员工登陆
    Emp login(String userName,String password);
}

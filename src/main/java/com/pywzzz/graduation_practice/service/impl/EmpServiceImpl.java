package com.pywzzz.graduation_practice.service.impl;

import com.pywzzz.graduation_practice.entity.Emp;
import com.pywzzz.graduation_practice.mapper.EmpMapper;
import com.pywzzz.graduation_practice.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: hy
 * @create: 2022-11-24 09:51:58
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {
    @Override
    public Emp login(String userName, String password) {
        return this.getBaseMapper().getByUserNameAndPassword(userName,password);
    }

    @Override
    public PageInfo<Emp> listByPage(Integer page, Integer limit, String empName) {
        //设置分页需要的参数
        PageHelper.startPage(page,limit);
        //调用条件查询方法
        List<Emp> empList = this.getBaseMapper().listByEmpName(empName);
        //使用分页对象封装查询结果
        PageInfo<Emp> pi = new PageInfo<>(empList);
        return pi;
    }

    @Override
    public int add(Emp emp) {
        return this.getBaseMapper().add(emp);
    }
}

package com.pywzzz.graduation_practice.service.impl;

import com.pywzzz.graduation_practice.entity.Emp;
import com.pywzzz.graduation_practice.mapper.EmpMapper;
import com.pywzzz.graduation_practice.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {
    @Override
    public Emp login(String userName, String password) {
        return this.getBaseMapper().getByUserNameAndPassword(userName,password);
    }
}

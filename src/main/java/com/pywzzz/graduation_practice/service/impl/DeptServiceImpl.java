package com.pywzzz.graduation_practice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pywzzz.graduation_practice.entity.Dept;
import com.pywzzz.graduation_practice.mapper.DeptMapper;
import com.pywzzz.graduation_practice.service.IDeptService;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
}

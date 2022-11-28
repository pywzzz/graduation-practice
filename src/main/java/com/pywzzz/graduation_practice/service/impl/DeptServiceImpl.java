package com.pywzzz.graduation_practice.service.impl;

import com.pywzzz.graduation_practice.entity.Dept;
import com.pywzzz.graduation_practice.mapper.DeptMapper;
import com.pywzzz.graduation_practice.service.IDeptService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author: hy
 * @create: 2022-11-23 08:35:56
 * 部门业务层
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Override
    public PageInfo<Dept> listByPage(Integer page, Integer limit,String searchDeptName) {
        //使用PageHelper插件，设置分页参数
        PageHelper.startPage(page,limit);
        //做数据查询
        //List<Dept> deptList = this.list();
        //构建查询条件包装器
        QueryWrapper qw = new QueryWrapper();
        if(!Objects.isNull(searchDeptName)) {
            qw.like("dept_name", searchDeptName);
        }
        //实现条件查询
        List deptList = this.list(qw);
        //使用分页对象封装查询结果
        PageInfo<Dept> pi = new PageInfo<>(deptList);
        return pi;
    }
}
package com.pywzzz.graduation_practice.service.impl;

import com.pywzzz.graduation_practice.entity.Role;
import com.pywzzz.graduation_practice.mapper.RoleMapper;
import com.pywzzz.graduation_practice.service.IRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author: hy
 * @create: 2022-11-23 11:46:15
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Override
    public PageInfo<Role> listByPage(Integer page, Integer limit, String searchRoleName) {
        //设置分页查询的参数
        PageHelper.startPage(page,limit);
        //构建查询包装器，实现条件查询
        QueryWrapper<Role> qw = new QueryWrapper<>();
        if(!Objects.isNull(searchRoleName)){
            qw.like("role_name",searchRoleName);
        }
        //只查询未删除的数据
        qw.eq("delete_flag","0");
        //执行查询
        List<Role> roleList = this.list(qw);
        //将查询结果封装成分页对象
        PageInfo<Role> pi = new PageInfo<>(roleList);
        return pi;
    }
}


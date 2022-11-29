package com.pywzzz.graduation_practice.service;

import com.pywzzz.graduation_practice.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * @author: hy
 * @create: 2022-11-23 11:45:48
 */
public interface IRoleService extends IService<Role> {
    public PageInfo<Role> listByPage(Integer page,Integer limit,String searchRoleName);
}


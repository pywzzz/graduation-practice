package com.pywzzz.graduation_practice.service;

import com.pywzzz.graduation_practice.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * 部门业务层接口
 */
public interface IDeptService extends IService<Dept> {
    //根据页码和分页条数，做分页查询
    PageInfo<Dept> listByPage(Integer page,Integer limit,String searchDeptName);
}


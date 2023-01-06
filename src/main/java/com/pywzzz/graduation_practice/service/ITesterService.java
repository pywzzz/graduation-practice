package com.pywzzz.graduation_practice.service;

import com.pywzzz.graduation_practice.entity.Tester;
import com.pywzzz.graduation_practice.entity.TesterVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * 业务层接口
 */
public interface ITesterService extends IService<Tester> {
    //定义查询指定测试者的性格色彩数据
    TesterVo getById(Integer id);
    //分页查询测试者信息
    PageInfo<TesterVo> listByPage(Integer page,Integer limit);
}

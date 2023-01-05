package com.pywzzz.graduation_practice.service;

import com.pywzzz.graduation_practice.entity.Tester;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pywzzz.graduation_practice.entity.TesterVo;

/**
 * 业务层接口
 */
public interface ITesterService extends IService<Tester> {
    //定义查询指定测试者的性格色彩数据
    TesterVo getById(Integer id);
}

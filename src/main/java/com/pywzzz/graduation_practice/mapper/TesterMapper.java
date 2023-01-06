package com.pywzzz.graduation_practice.mapper;

import com.pywzzz.graduation_practice.entity.Tester;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pywzzz.graduation_practice.entity.TesterVo;

import java.util.List;
/**
 * 数据访问层接口
 */
public interface TesterMapper extends BaseMapper<Tester> {
    //定义针对测试者性格色彩数据的查询
    TesterVo getById(Integer id);
    //查询所有的测试者信息
    List<TesterVo> listAll();
}

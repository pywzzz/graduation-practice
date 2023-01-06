package com.pywzzz.graduation_practice.service.impl;

import com.pywzzz.graduation_practice.entity.Tester;
import com.pywzzz.graduation_practice.entity.TesterVo;
import com.pywzzz.graduation_practice.mapper.TesterMapper;
import com.pywzzz.graduation_practice.service.ITesterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: hy
 * @create: 2023-01-03 11:35:12
 */
@Service
public class TesterServiceImpl extends ServiceImpl<TesterMapper, Tester>
        implements ITesterService {
    //根据测试者编号，查询性格数据
    @Override
    public TesterVo getById(Integer id) {
        return this.getBaseMapper().getById(id);
    }

    //实现分页查询
    @Override
    public PageInfo<TesterVo> listByPage(Integer page, Integer limit) {
        //使用分页插件设置分页配置
        //page:当前页码 limit:每页显示几条
        PageHelper.startPage(page,limit);
        //查询测试者信息
        List<TesterVo> testerVoList = this.getBaseMapper().listAll();
        //讲查询结果进行分页封装
        PageInfo<TesterVo> pi = new PageInfo<>(testerVoList);
        return pi;
    }
}

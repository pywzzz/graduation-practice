package com.pywzzz.graduation_practice.service.impl;

import com.pywzzz.graduation_practice.entity.Tester;
import com.pywzzz.graduation_practice.entity.TesterVo;
import com.pywzzz.graduation_practice.mapper.TesterMapper;
import com.pywzzz.graduation_practice.service.ITesterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
}

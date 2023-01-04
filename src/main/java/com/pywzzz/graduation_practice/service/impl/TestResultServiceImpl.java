package com.pywzzz.graduation_practice.service.impl;

import com.pywzzz.graduation_practice.entity.TestResult;
import com.pywzzz.graduation_practice.mapper.TestResultMapper;
import com.pywzzz.graduation_practice.service.ITestResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author: hy
 * @create: 2023-01-04 10:54:22
 */
@Service
public class TestResultServiceImpl extends ServiceImpl<TestResultMapper, TestResult>
                                   implements ITestResultService {
}

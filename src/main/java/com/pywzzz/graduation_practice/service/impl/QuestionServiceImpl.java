package com.pywzzz.graduation_practice.service.impl;

import com.pywzzz.graduation_practice.entity.Question;
import com.pywzzz.graduation_practice.mapper.QuestionMapper;
import com.pywzzz.graduation_practice.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author: hy
 * @create: 2023-01-03 09:18:59
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
                                 implements IQuestionService {
}

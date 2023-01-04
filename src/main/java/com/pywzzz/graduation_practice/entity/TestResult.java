package com.pywzzz.graduation_practice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: hy
 * @create: 2023-01-04 10:50:04
 */
@Data
@TableName("tbl_test_result")
public class TestResult {
    //结果编号
    @TableId(type = IdType.AUTO)
    private Integer id;
    //测试者编号
    private Integer testerId;
    //题目编号
    private Integer questionId;
    //题目答案
    private String answer;
}

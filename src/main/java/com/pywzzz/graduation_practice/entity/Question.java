package com.pywzzz.graduation_practice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author: hy
 * @create: 2023-01-03 09:07:01
 */
@Data
@TableName("tbl_question")
public class Question {
    //题目编号
    @TableId(type= IdType.AUTO)
    private Integer id;
    //题目
    private String question;
    //选项A
    private String optionA;
    //选项B
    private String optionB;
    //选项C
    private String optionC;
    //选项D
    private String optionD;
    //题目类型:1 前15题 2 后15题
    private Integer type;
    //状态
    private Integer status;
    //删除标记
    private Integer flag;
    //创建时间
    private Date createTime;
    //创建人
    private String createBy;
    //修改时间
    private Date updateTime;
    //修改人
    private String updateBy;
}

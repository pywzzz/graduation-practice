package com.pywzzz.graduation_practice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author: hy
 * @create: 2023-01-03 11:30:55
 */
@Data
@TableName("tbl_tester")
public class Tester {
    //编号
    @TableId(type = IdType.AUTO)
    private Integer id;
    //姓名
    private String name;
    //手机
    private String phone;
    //状态
    private Integer status;
    //创建时间(测试时间)
    private Date createTime;
}

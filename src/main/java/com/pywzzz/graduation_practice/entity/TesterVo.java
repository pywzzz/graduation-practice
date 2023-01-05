package com.pywzzz.graduation_practice.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: hy
 * @create: 2023-01-05 09:56:03
 */
@Data
public class TesterVo {
    //测试者的信息
    private Integer id;
    private String name;
    private String phone;
    private Integer status;
    private Date createTime;
    //性格色彩数据
    private Integer red;
    private Integer blue;
    private Integer yellow;
    private Integer green;
}

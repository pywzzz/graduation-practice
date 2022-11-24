package com.pywzzz.graduation_practice.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tbl_emp")
public class Emp {
    //员工编号
    @TableId(type = IdType.AUTO)
    private Integer empId;
    //姓名
    private String empName;
    //用户名
    private String userName;
    //密码
    private String password;
    //性别
    private String sex;
    //员工状态
    private String status;
    //删除标记
    private String deleteFlag;
    //生日
    private Date birthday;
    //手机
    private String phone;
    //邮箱
    private String email;
    //创建人
    private String createBy;
    //创建时间
    private Date createTime;
    //修改人
    private String updateBy;
    //修改时间
    private Date updateTime;

    //部门对象
    @TableField(exist = false) //该字段在数据库中不存在
    private Dept dept;
    //角色对象
    @TableField(exist = false) //该字段在数据库中不存在
    private Role role;

}


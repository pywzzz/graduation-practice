package com.pywzzz.graduation_practice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tbl_role")
public class Role {
    //角色编号
    @TableId(type = IdType.AUTO)
    private Integer roleId;

    //角色名称
    private String roleName;

    //角色状态
    private String status;

    //删除标记
    private String deleteFlag;

    //创建人
    private String createBy;

    //创建时间
    private Date createTime;

    //更新人
    private String updateBy;

    //更新时间
    private Date updateTime;
}
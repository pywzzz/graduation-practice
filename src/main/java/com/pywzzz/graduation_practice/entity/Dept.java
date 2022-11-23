package com.pywzzz.graduation_practice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tbl_dept")
public class Dept {
    //部门编号
    @TableId(type= IdType.AUTO)
    private Integer deptId;
    //部门名称
    private String deptName;
    //部门状态
    private String status;
    //删除标记
    private String deleteFlag;
    //创建人
    private String createBy;
    //创建时间
    private Date createTime;
    //修改人
    private String updateBy;
    //修改时间
    private Date updateTime;
}

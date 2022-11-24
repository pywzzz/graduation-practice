package com.pywzzz.graduation_practice.mapper;

import com.pywzzz.graduation_practice.entity.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper extends BaseMapper<Emp> {
    //根据用户名和密码查询员工对象
    Emp getByUserNameAndPassword(@Param("userName") String userName,
                                 @Param("password") String password);
}
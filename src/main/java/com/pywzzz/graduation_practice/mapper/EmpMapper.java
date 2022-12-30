package com.pywzzz.graduation_practice.mapper;

import com.pywzzz.graduation_practice.entity.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper extends BaseMapper<Emp> {
    //根据用户名和密码查询员工对象
    Emp getByUserNameAndPassword(@Param("userName") String userName,
                                 @Param("password") String password);

    //根据前台查询条件查询员工数据
    List<Emp> listByEmpName(@Param("empName") String empName);
    //添加员工
    int add(Emp emp);
    //修改员工
    int update(Emp emp);
}
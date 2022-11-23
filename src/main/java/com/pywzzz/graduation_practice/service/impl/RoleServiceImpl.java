package com.pywzzz.graduation_practice.service.impl;

import com.pywzzz.graduation_practice.entity.Role;
import com.pywzzz.graduation_practice.mapper.RoleMapper;
import com.pywzzz.graduation_practice.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author: hy
 * @create: 2022-11-23 11:46:15
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
}

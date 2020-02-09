package com.github.bxy.authority.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.bxy.authority.dao.auth.UserRoleMapper;
import com.github.bxy.authority.entity.auth.UserRole;
import com.github.bxy.authority.service.auth.UserRoleService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.github.bxy.common.constant.BizConstant.INIT_ROLE_ID;

/**
 * <p>
 * 业务实现类
 * 角色分配
 * 账号角色绑定
 * </p>
 *
 * @author bxy
 * @date 2019-07-03
 */
@Slf4j
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    public void initAdmin(Long userId) {
        UserRole userRole = UserRole.builder()
                .userId(userId).roleId(INIT_ROLE_ID)
                .build();

        super.save(userRole);
    }
}

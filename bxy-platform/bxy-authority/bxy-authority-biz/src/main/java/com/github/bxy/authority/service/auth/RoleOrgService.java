package com.github.bxy.authority.service.auth;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.bxy.authority.entity.auth.RoleOrg;

/**
 * <p>
 * 业务接口
 * 角色组织关系
 * </p>
 *
 * @author bxy
 * @date 2019-07-03
 */
public interface RoleOrgService extends IService<RoleOrg> {

    /**
     * 根据角色id查询
     *
     * @param id
     * @return
     */
    List<Long> listOrgByRoleId(Long id);
}
package com.github.bxy.authority.dao.auth;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.bxy.authority.entity.auth.Menu;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * 菜单
 * </p>
 *
 * @author bxy
 * @date 2019-07-03
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询用户可用菜单
     *
     * @param group
     * @param userId
     * @return
     */
    List<Menu> findVisibleMenu(@Param("group") String group, @Param("userId") Long userId);
}

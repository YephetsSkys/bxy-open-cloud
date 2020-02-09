package com.github.bxy.authority.dao.defaults;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.bxy.authority.entity.defaults.Tenant;

import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * 企业
 * </p>
 *
 * @author bxy
 * @date 2019-10-25
 */
@Repository
@SqlParser(filter = true)
public interface TenantMapper extends BaseMapper<Tenant> {

}

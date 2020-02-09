package com.github.bxy.authority.dao.defaults;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.bxy.authority.entity.defaults.GlobalUser;

import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * 全局账号
 * </p>
 *
 * @author bxy
 * @date 2019-10-25
 */
@Repository
@SqlParser(filter = true)
public interface GlobalUserMapper extends BaseMapper<GlobalUser> {

}

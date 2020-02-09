package com.github.bxy.authority.dao.core;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.github.bxy.authority.entity.core.Station;
import com.github.bxy.database.mybatis.auth.DataScope;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * 岗位
 * </p>
 *
 * @author bxy
 * @date 2019-07-22
 */
@Repository
public interface StationMapper extends BaseMapper<Station> {
    /**
     * 分页查询岗位信息（含角色）
     *
     * @param page
     * @param queryWrapper
     * @param dataScope
     * @return
     */
    IPage<Station> findStationPage(IPage page, @Param(Constants.WRAPPER) Wrapper<Station> queryWrapper, DataScope dataScope);
}

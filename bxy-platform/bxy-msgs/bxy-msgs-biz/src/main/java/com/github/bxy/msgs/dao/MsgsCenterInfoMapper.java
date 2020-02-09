package com.github.bxy.msgs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.bxy.msgs.dto.MsgsCenterInfoPageResultDTO;
import com.github.bxy.msgs.dto.MsgsCenterInfoQueryDTO;
import com.github.bxy.msgs.entity.MsgsCenterInfo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * 消息中心
 * </p>
 *
 * @author bxy
 * @date 2019-08-01
 */
@Repository
public interface MsgsCenterInfoMapper extends BaseMapper<MsgsCenterInfo> {
    /**
     * 查询消息中心分页数据
     *
     * @param page
     * @param param
     * @return
     */
    IPage<MsgsCenterInfoPageResultDTO> page(IPage page, @Param("data") MsgsCenterInfoQueryDTO param);
}

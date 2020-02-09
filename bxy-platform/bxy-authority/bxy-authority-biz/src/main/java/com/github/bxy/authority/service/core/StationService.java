package com.github.bxy.authority.service.core;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.bxy.authority.dto.core.StationPageDTO;
import com.github.bxy.authority.entity.core.Station;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 业务接口
 * 岗位
 * </p>
 *
 * @author bxy
 * @date 2019-07-22
 */
public interface StationService extends IService<Station> {
    /**
     * 按权限查询岗位的分页信息
     *
     * @param page
     * @param data
     * @return
     */
    IPage<Station> findStationPage(IPage page, StationPageDTO data);

    /**
     * 根据id 查询
     *
     * @param ids
     * @return
     */
    Map<Serializable, Object> findStationByIds(Set<Serializable> ids);
}

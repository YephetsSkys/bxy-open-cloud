package com.github.bxy.authority.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.bxy.authority.dto.auth.SystemApiScanSaveDTO;
import com.github.bxy.authority.entity.auth.SystemApi;

/**
 * <p>
 * 业务接口
 * API接口
 * </p>
 *
 * @author bxy
 * @date 2019-12-15
 */
public interface SystemApiService extends IService<SystemApi> {
    /**
     * 批量保存
     *
     * @param data
     * @return
     */
    Boolean batchSave(SystemApiScanSaveDTO data);
}

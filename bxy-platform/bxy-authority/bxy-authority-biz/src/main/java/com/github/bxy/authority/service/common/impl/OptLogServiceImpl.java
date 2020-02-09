package com.github.bxy.authority.service.common.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.bxy.authority.dao.common.OptLogMapper;
import com.github.bxy.authority.entity.common.OptLog;
import com.github.bxy.authority.service.common.OptLogService;
import com.github.bxy.dozer.DozerUtils;
import com.github.bxy.log.entity.OptLogDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 系统日志
 * </p>
 *
 * @author bxy
 * @date 2019-07-02
 */
@Slf4j
@Service
public class OptLogServiceImpl extends ServiceImpl<OptLogMapper, OptLog> implements OptLogService {
    @Autowired
    DozerUtils dozer;

    @Override
    public boolean save(OptLogDTO entity) {
        return super.save(dozer.map(entity, OptLog.class));
    }
}

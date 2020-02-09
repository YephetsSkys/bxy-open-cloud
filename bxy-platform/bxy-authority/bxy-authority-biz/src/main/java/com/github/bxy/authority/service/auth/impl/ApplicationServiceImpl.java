package com.github.bxy.authority.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.bxy.authority.dao.auth.ApplicationMapper;
import com.github.bxy.authority.entity.auth.Application;
import com.github.bxy.authority.service.auth.ApplicationService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 应用
 * </p>
 *
 * @author bxy
 * @date 2019-12-15
 */
@Slf4j
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

}

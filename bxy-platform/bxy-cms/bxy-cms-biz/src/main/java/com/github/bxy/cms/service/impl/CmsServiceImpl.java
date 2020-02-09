package com.github.bxy.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.bxy.cms.dao.CmsMapper;
import com.github.bxy.cms.entity.Cms;
import com.github.bxy.cms.service.CmsService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 内容管理系统
 * </p>
 *
 * @author bxy
 * @date 2019-08-13
 */
@Slf4j
@Service
public class CmsServiceImpl extends ServiceImpl<CmsMapper, Cms> implements CmsService {

}

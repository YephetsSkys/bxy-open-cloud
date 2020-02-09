package com.github.bxy.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.bxy.cms.dao.ArticleMapper;
import com.github.bxy.cms.entity.CmsArticle;
import com.github.bxy.cms.service.ArticleService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 内容管理系统-文章管理
 * </p>
 *
 * @author bxy
 * @date 2019-08-13
 */
@Slf4j
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, CmsArticle> implements ArticleService {

}

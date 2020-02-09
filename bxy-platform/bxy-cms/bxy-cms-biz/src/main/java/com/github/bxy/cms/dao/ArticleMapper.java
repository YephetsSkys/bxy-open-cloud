package com.github.bxy.cms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.bxy.cms.entity.Cms;

import com.github.bxy.cms.entity.CmsArticle;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * 内容管理
 * </p>
 *
 * @author bxy
 * @date 2019-08-13
 */
@Repository
public interface ArticleMapper extends BaseMapper<CmsArticle> {

}

package com.github.bxy.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.bxy.demo.entity.Product;

import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * 商品
 * </p>
 *
 * @author bxy
 * @date 2019-08-13
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {

}

package com.github.bxy.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.bxy.demo.dao.ProductMapper;
import com.github.bxy.demo.entity.Product;
import com.github.bxy.demo.service.ProductService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 商品
 * </p>
 *
 * @author bxy
 * @date 2019-08-13
 */
@Slf4j
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}

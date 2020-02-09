package com.github.bxy.demo.controller.test;

import com.github.bxy.base.BaseController;
import com.github.bxy.base.R;
import com.github.bxy.demo.entity.Product;
import com.github.bxy.demo.service.ProductService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分布式事务测试类
 *
 * @author bxy
 * @date 2019/08/12
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/seata")
@Api(value = "SeataTxController", tags = "分布式事务测试类")
public class SeataTxController extends BaseController {

    @Autowired
    private ProductService productService;


    @PostMapping("/save")
    public R<Product> save(@RequestBody Product data) {
        log.info("data={}", data);
        productService.save(data);
        return success(data);
    }

    @PostMapping("/saveEx")
    public R<Product> saveEx(@RequestBody Product data) {
        log.info("data={}", data);
        productService.save(data);
        int i = 1 / 0;
        return success(data);
    }
}

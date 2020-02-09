package com.github.bxy.demo.controller.test.model;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * 订单测试DTO
 *
 * @author bxy
 * @date 2019/08/01
 */
@Data
@ToString
public class Orddder implements Serializable {
    private Long id;
    private String name;
    private Producttt producttt;
}

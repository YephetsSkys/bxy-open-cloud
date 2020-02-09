package com.github.bxy.cms.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.bxy.base.BaseController;
import com.github.bxy.base.R;
import com.github.bxy.base.entity.SuperEntity;
import com.github.bxy.database.mybatis.conditions.Wraps;
import com.github.bxy.database.mybatis.conditions.query.LbqWrapper;
import com.github.bxy.dozer.DozerUtils;
import com.github.bxy.log.annotation.SysLog;
import com.github.bxy.cms.dto.CmsSaveDTO;
import com.github.bxy.cms.dto.CmsUpdateDTO;
import com.github.bxy.cms.entity.Cms;
import com.github.bxy.cms.service.CmsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * 内容管理系统CMS
 * </p>
 *
 * @author bxy
 * @date 2019-08-13
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/cms")
@Api(value = "Cms", tags = "内容管理系统")
public class CmsController extends BaseController {

    @Autowired
    private CmsService cmsService;
    @Autowired
    private DozerUtils dozer;

    /**
     * 分页查询订单
     *
     * @param data 分页查询对象
     * @return 查询结果
     */
    @ApiOperation(value = "分页查询内容管理系统", notes = "分页查询内容管理系统")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    @SysLog("分页查询内容管理系统")
    public R<IPage<Cms>> page(Cms data) {
        IPage<Cms> page = getPage();
        // 构建值不为null的查询条件
        LbqWrapper<Cms> query = Wraps.lbQ(data);
        cmsService.page(page, query);
        return success(page);
    }

    /**
     * 查询订单
     *
     * @param id 主键id
     * @return 查询结果
     */
    @ApiOperation(value = "查询内容管理系统", notes = "查询内容管理系统")
    @GetMapping("/{id}")
    @SysLog("查询内容管理系统")
    public R<Cms> get(@PathVariable Long id) {
        return success(cmsService.getById(id));
    }

    /**
     * 新增内容管理系统
     *
     * @param data 新增对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增内容管理系统", notes = "新增内容管理系统不为空的字段")
    @PostMapping
    @SysLog("新增订单")
    public R<Cms> save(@RequestBody @Validated CmsSaveDTO data) {
        Cms cms = dozer.map(data, Cms.class);
        cmsService.save(cms);
        return success(cms);
    }

    /**
     * 修改内容管理系统
     *
     * @param data 修改对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改内容管理系统", notes = "修改内容管理系统不为空的字段")
    @PutMapping
    @SysLog("修改订单")
    public R<Cms> update(@RequestBody @Validated(SuperEntity.Update.class) CmsUpdateDTO data) {
        Cms cms = dozer.map(data, Cms.class);
        cmsService.updateById(cms);
        return success(cms);
    }

    /**
     * 删除内容管理系统
     *
     * @param id 主键id
     * @return 删除结果
     */
    @ApiOperation(value = "删除内容管理系统", notes = "根据id物理删除内容管理系统")
    @DeleteMapping(value = "/{id}")
    @SysLog("删除内容管理系统")
    public R<Boolean> delete(@PathVariable Long id) {
        cmsService.removeById(id);
        return success(true);
    }

}

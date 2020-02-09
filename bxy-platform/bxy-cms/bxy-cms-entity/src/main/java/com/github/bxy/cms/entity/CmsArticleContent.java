package com.github.bxy.cms.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.bxy.base.entity.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * <p>
 * 文章内容实体类
 * 内容管理
 * </p>
 *
 * @author bxy
 * @since 2020-02-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("cms_article_content")
@ApiModel(value = "CmsArticleContent", description = "内容管理系统文章内容")
public class CmsArticleContent extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 前端显示ID
     */
    @ApiModelProperty(value = "前端显示ID")
    @Length(max = 100, message = "前端显示ID，仅用前端")
    @TableField("aid")
    private String aid;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    @Length(max = 100, message = "显示顺序")
    @TableField("pagenum")
    private String pagenum;

    /**
     * 文章内容
     */
    @ApiModelProperty(value = "文章内容")
    @TableField("content")
    private String content;

    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    @Length(max = 100, message = "添加时间")
    @TableField("addtime")
    private String addtime;

    /**
     * 是否显示 N不显示，Y显示
     */
    @ApiModelProperty(value = "是否显示")
    @Length(max = 1, message = "是否显示")
    @TableField("showstatus")
    private String showstatus;
    
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    @Length(max = 255, message = "编号长度不能超过255")
    @TableField("code")
    private String code;


    @Builder
    public CmsArticleContent(Long id, LocalDateTime createTime, Long createUser, LocalDateTime updateTime, Long updateUser,
                 String content, String pagenum) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.content = content;
        this.pagenum = pagenum;
    }

}

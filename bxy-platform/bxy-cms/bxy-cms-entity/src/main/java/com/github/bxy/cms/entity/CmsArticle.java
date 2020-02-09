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
 * 实体类
 * 内容管理
 * </p>
 *
 * @author bxy
 * @since 2019-08-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("cms_article")
@ApiModel(value = "CmsArticle", description = "内容管理系统")
public class CmsArticle extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    @Length(max = 255, message = "名称长度不能超过255")
    @TableField("title")
    private String title;

    /**
     * 前端显示ID
     */
    @ApiModelProperty(value = "前端显示ID")
    @Length(max = 100, message = "前端显示ID，仅用前端")
    @TableField("aid")
    private String aid;

    /**
     * seo优化标题
     */
    @ApiModelProperty(value = "seo优化标题")
    @Length(max = 255, message = "标题长度不能超过255")
    @TableField("seotitle")
    private String seotitle;

    /**
     * 来源
     */
    @ApiModelProperty(value = "来源")
    @Length(max = 50, message = "来源长度不能超过50")
    @TableField("comefrom")
    private String comefrom;

    /**
     * 来自站点
     */
    @ApiModelProperty(value = "来自站点")
    @Length(max = 100, message = "来自站点")
    @TableField("fromsite")
    private String fromsite;

    /**
     * 作者
     */
    @ApiModelProperty(value = "作者")
    @Length(max = 100, message = "作者")
    @TableField("author")
    private String author;

    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    @Length(max = 100, message = "添加时间")
    @TableField("addtime")
    private String addtime;


    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @Length(max = 100, message = "更新时间")
    @TableField("modtime")
    private String modtime;

    /**
     * 发布时间
     */
    @ApiModelProperty(value = "发布时间")
    @Length(max = 100, message = "发布时间")
    @TableField("publishtime")
    private String publishtime;
    
    /**
     * 文章相关词
     */
    @ApiModelProperty(value = "文章相关词")
    @Length(max = 100, message = "文章相关词")
    @TableField("tagword")
    private String tagword;

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词")
    @Length(max = 100, message = "关键词")
    @TableField("keyword")
    private String keyword;

    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    @Length(max = 300, message = "摘要")
    @TableField("summary")
    private String summary;

    /**
     * 所属专题
     */
    @ApiModelProperty(value = "所属专题")
    @Length(max = 100, message = "所属专题")
    @TableField("themelist")
    private String themelist;

    /**
     * 是否显示 N不显示，Y显示
     */
    @ApiModelProperty(value = "是否显示")
    @Length(max = 1, message = "是否显示")
    @TableField("showstatus")
    private String showstatus;
    
     /**
     * 文章状态：0通过审核，1已经提交，
     */
    @ApiModelProperty(value = "文章状态")
    @Length(max = 1, message = "文章状态")
    @TableField("articlestatus")
    private String articlestatus;   

     /**
     * 模板id
     */
    @ApiModelProperty(value = "模板id")
    @Length(max = 1, message = "模板id")
    @TableField("templateid")
    private String templateid;      

     /**
     * 浏览量
     */
    @ApiModelProperty(value = "浏览量")
    @Length(max = 1, message = "浏览量")
    @TableField("shownum")
    private String shownum;   
   
    //litpic varchar(255) comment '文章封面图',
 
    //attrid varchar(255) comment '所属属性',
    //attachment varchar(255) comment '附件',
   


    
    @Builder
    public CmsArticle(Long id, LocalDateTime createTime, Long createUser, LocalDateTime updateTime, Long updateUser,
                 String title, String aid) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.title = title;
        this.aid = aid;
    }

}

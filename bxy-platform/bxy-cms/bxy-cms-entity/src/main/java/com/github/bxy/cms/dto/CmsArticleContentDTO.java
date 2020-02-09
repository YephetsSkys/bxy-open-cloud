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
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CmsArticleContentDTO", description = "内容管理系统文章内容")
public class CmsArticleContentDTO extends CmsArticleContent {

    private static final long serialVersionUID = 1L;

    public static CmsArticleContentDTO build() {
        return new CmsArticleContentDTO();
    }
}

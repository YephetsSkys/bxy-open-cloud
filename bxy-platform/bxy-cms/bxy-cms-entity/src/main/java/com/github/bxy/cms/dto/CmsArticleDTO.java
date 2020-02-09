package com.github.bxy.cms.dto;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.bxy.base.entity.Entity;

import com.github.bxy.cms.entity.CmsArticle;
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
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CmsArticleDTO", description = "内容管理系统文章")
public class CmsArticleDTO extends CmsArticle {

    private static final long serialVersionUID = 1L;



    public static CmsArticleDTO build() {
        return new CmsArticleDTO();
    }

}

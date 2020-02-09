package com.github.bxy.authority.dto.common;

import com.github.bxy.base.entity.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 实体类
 * 字典项
 * </p>
 *
 * @author bxy
 * @since 2020-01-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "DictionaryItemUpdateDTO", description = "字典项")
public class DictionaryItemUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @NotNull(message = "id不能为空", groups = SuperEntity.Update.class)
    private Long id;

    /**
     * 字典id
     */
    @ApiModelProperty(value = "字典id")
    @NotNull(message = "字典id不能为空")
    private Long dictionaryId;
    /**
     * 字典编码
     */
    @ApiModelProperty(value = "字典编码")
    @NotEmpty(message = "字典编码不能为空")
    @Length(max = 64, message = "字典编码长度不能超过64")
    private String dictionaryCode;
    /**
     * 编码
     */
    @ApiModelProperty(value = "编码")
    @NotEmpty(message = "编码不能为空")
    @Length(max = 64, message = "编码长度不能超过64")
    private String code;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @NotEmpty(message = "名称不能为空")
    @Length(max = 64, message = "名称长度不能超过64")
    private String name;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Boolean status;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @Length(max = 255, message = "描述长度不能超过255")
    private String describe;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sortValue;

}

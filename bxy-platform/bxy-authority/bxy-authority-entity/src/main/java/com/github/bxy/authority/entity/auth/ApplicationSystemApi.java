package com.github.bxy.authority.entity.auth;

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

/**
 * <p>
 * 实体类
 * 应用接口
 * </p>
 *
 * @author bxy
 * @since 2019-12-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("c_auth_application_system_api")
@ApiModel(value = "ApplicationSystemApi", description = "应用接口")
public class ApplicationSystemApi extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 应用id
     */
    @ApiModelProperty(value = "应用id")
    @TableField("application_id")
    private Long applicationId;

    /**
     * 资源id
     */
    @ApiModelProperty(value = "资源id")
    @TableField("system_api_id")
    private Long systemApiId;


    @Builder
    public ApplicationSystemApi(Long id, LocalDateTime createTime, Long createUser, LocalDateTime updateTime, Long updateUser,
                                Long applicationId, Long systemApiId) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.applicationId = applicationId;
        this.systemApiId = systemApiId;
    }

}

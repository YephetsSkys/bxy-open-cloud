package com.github.bxy.authority.api.hystrix;

import java.util.List;

import com.github.bxy.authority.api.RoleApi;
import com.github.bxy.base.R;

import org.springframework.stereotype.Component;

/**
 * 角色查询API
 *
 * @author bxy
 * @date 2019/08/02
 */
@Component
public class RoleApiFallback implements RoleApi {
    @Override
    public R<List<Long>> findUserIdByCode(String[] codes) {
        return R.timeout();
    }
}

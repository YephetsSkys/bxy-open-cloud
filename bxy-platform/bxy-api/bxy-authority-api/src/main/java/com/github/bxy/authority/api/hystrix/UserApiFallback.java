package com.github.bxy.authority.api.hystrix;

import com.github.bxy.authority.api.UserApi;
import com.github.bxy.base.R;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户API熔断
 *
 * @author bxy
 * @date 2019/07/23
 */
@Component
public class UserApiFallback implements UserApi {
    @Override
    public Map<String, Object> getDataScopeById(Long id) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("dsType", 5);
        map.put("orgIds", Collections.emptyList());
        return map;
    }

    @Override
    public R<List<Long>> findAllUserId() {
        return R.timeout();
    }
}

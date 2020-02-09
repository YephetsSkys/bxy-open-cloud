package com.github.bxy.gateway.fallback;


import com.github.bxy.base.R;
import com.github.bxy.exception.code.ExceptionCode;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 响应超时熔断处理器
 *
 * @author bxy
 */
@RestController
public class FallbackController {

    @RequestMapping("/fallback")
    public Mono<R> fallback() {
        return Mono.just(R.fail(ExceptionCode.SYSTEM_TIMEOUT));
    }
}

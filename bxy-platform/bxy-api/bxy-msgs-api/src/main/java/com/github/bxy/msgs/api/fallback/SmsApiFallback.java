package com.github.bxy.msgs.api.fallback;

import com.github.bxy.base.R;
import com.github.bxy.msgs.api.SmsApi;
import com.github.bxy.sms.dto.SmsSendTaskDTO;
import com.github.bxy.sms.dto.VerificationCodeDTO;
import com.github.bxy.sms.entity.SmsTask;

import org.springframework.stereotype.Component;

/**
 * 熔断
 *
 * @author bxy
 * @date 2019/07/25
 */
@Component
public class SmsApiFallback implements SmsApi {
    @Override
    public R<SmsTask> send(SmsSendTaskDTO smsTaskDTO) {
        return R.timeout();
    }

    @Override
    public R<Boolean> sendCode(VerificationCodeDTO data) {
        return R.timeout();
    }

    @Override
    public R<Boolean> verification(VerificationCodeDTO data) {
        return R.timeout();
    }
}

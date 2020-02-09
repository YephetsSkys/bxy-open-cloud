package com.github.bxy.msgs.api;


import com.github.bxy.base.R;
import com.github.bxy.base.entity.SuperEntity;
import com.github.bxy.msgs.api.fallback.SmsApiFallback;
import com.github.bxy.sms.dto.SmsSendTaskDTO;
import com.github.bxy.sms.dto.VerificationCodeDTO;
import com.github.bxy.sms.entity.SmsTask;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 文件接口
 *
 * @author bxy
 * @date 2019/06/21
 */
@FeignClient(name = "${bxy.feign.msgs-server:bxy-msgs-server}", fallback = SmsApiFallback.class)
public interface SmsApi {
    /**
     * 短信发送
     *
     * @param smsTaskDTO
     * @return
     */
    @RequestMapping(value = "/smsTask/send", method = RequestMethod.POST)
    R<SmsTask> send(@RequestBody SmsSendTaskDTO smsTaskDTO);

    /**
     * 发送验证码
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/verification/send")
    R<Boolean> sendCode(@Validated @RequestBody VerificationCodeDTO data);

    /**
     * 验证
     *
     * @param data
     * @return
     */
    @PostMapping("/verification")
    R<Boolean> verification(@Validated(SuperEntity.Update.class) @RequestBody VerificationCodeDTO data);
}

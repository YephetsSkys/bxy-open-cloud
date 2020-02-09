package com.github.bxy.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.bxy.sms.dao.SmsSendStatusMapper;
import com.github.bxy.sms.entity.SmsSendStatus;
import com.github.bxy.sms.service.SmsSendStatusService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 短信发送状态
 * </p>
 *
 * @author bxy
 * @date 2019-08-01
 */
@Slf4j
@Service
public class SmsSendStatusServiceImpl extends ServiceImpl<SmsSendStatusMapper, SmsSendStatus> implements SmsSendStatusService {

}

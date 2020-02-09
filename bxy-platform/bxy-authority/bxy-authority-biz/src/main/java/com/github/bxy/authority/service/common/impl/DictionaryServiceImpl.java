package com.github.bxy.authority.service.common.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.bxy.authority.dao.common.DictionaryMapper;
import com.github.bxy.authority.entity.common.Dictionary;
import com.github.bxy.authority.service.common.DictionaryService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 字典目录
 * </p>
 *
 * @author bxy
 * @date 2019-07-02
 */
@Slf4j
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {

}

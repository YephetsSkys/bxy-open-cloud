package com.github.bxy.file.strategy;

import java.util.List;

import com.github.bxy.file.domain.FileDeleteDO;
import com.github.bxy.file.entity.File;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件策略接口
 *
 * @author bxy
 * @date 2019/06/17
 */
public interface FileStrategy {
    /**
     * 文件上传
     *
     * @param file 文件
     * @return 文件对象
     * @author bxy
     * @date 2019-05-06 16:38
     */
    File upload(MultipartFile file);

    /**
     * 删除源文件
     *
     * @param list 列表
     * @return
     * @author bxy
     * @date 2019-05-07 11:41
     */
    boolean delete(List<FileDeleteDO> list);

}

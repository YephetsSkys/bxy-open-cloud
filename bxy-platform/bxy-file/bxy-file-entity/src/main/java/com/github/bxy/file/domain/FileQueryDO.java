package com.github.bxy.file.domain;


import com.github.bxy.file.entity.File;

import lombok.Data;

/**
 * 文件查询 DO
 *
 * @author bxy
 * @date 2019/05/07
 */
@Data
public class FileQueryDO extends File {
    private File parent;

}

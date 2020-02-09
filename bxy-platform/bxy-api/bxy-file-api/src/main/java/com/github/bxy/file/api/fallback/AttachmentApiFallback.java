package com.github.bxy.file.api.fallback;

import com.github.bxy.base.R;
import com.github.bxy.file.api.AttachmentApi;
import com.github.bxy.file.dto.AttachmentDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 熔断
 *
 * @author bxy
 * @date 2019/07/25
 */
@Component
public class AttachmentApiFallback implements AttachmentApi {
    @Override
    public R<AttachmentDTO> upload(MultipartFile file, Boolean isSingle, Long id, String bizId, String bizType) {
        return R.timeout();
    }
}

package com.mall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by peter on 17/9/13.
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}

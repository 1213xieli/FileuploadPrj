package com.xieli.service;

import com.xieli.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * FileService
 * time:2019/7/12
 * author:xieli
 */
public interface FileService {

    FileInfo insertFileInfo(MultipartFile file, Map<String, Object> map) throws Exception;

    List<FileInfo> selectPage() throws Exception;
}

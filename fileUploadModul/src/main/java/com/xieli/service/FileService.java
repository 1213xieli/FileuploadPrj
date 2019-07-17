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

    /* *
     * @description 查出全部数据
     * @author xieli
     * @date  1:49 2019/7/18
     * @param []
     * @return java.util.List<com.xieli.entity.FileInfo>
     **/
    List<FileInfo> selectPage() throws Exception;

    /* *
     * @description 真分页
     * @author xieli
     * @date  1:49 2019/7/18
     * @param [info]
     * @return java.util.List<com.xieli.entity.FileInfo>
     **/
    List<FileInfo> getListPage(FileInfo info) throws Exception;

    /* *
     * @description 分页查全部条数
     * @author xieli
     * @date  1:49 2019/7/18
     * @param [info]
     * @return int
     **/
    int getTotal(FileInfo info)throws Exception;
}

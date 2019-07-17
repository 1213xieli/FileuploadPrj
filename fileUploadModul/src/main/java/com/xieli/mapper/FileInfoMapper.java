package com.xieli.mapper;

import com.xieli.entity.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface FileInfoMapper {

    int addFileInfo(FileInfo fileInfo);

    List<FileInfo> selectFileList();


}

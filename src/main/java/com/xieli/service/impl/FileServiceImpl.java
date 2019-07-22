package com.xieli.service.impl;

import com.xieli.entity.FileInfo;
import com.xieli.mapper.FileInfoMapper;
import com.xieli.service.FileService;
import com.xieli.utils.Func;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * FileServiceImpl
 * time:2019/7/12
 * author:xieli
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileInfoMapper fileInfoMapper;
    @Value("${config.defaultURL}")
    private String defaultURL;

    @Override
    public FileInfo insertFileInfo(MultipartFile file, Map<String, Object> map) throws Exception {
        if (file.isEmpty())
            throw new Exception("请上传文件");

        String fileName = file.getOriginalFilename();
        String fileType = null;
        if (file.getOriginalFilename().contains("."))
        {
            fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            fileName = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."));
        }

        String fileNameTime = Func.newGuid();
        //new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + file.getOriginalFilename();

        //加个时间戳，尽量避免文件名称重复
        String filePath = "E:/fileUpload/" +fileNameTime;
        File dest = new File(filePath);
        if (dest.exists())
            throw new Exception("文件已经存在");
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists())
            dest.getParentFile().mkdir();

        String fileUrl = defaultURL + fileNameTime;

        FileInfo info = new FileInfo();
        info.setId(Func.newGuid());
        info.setTitle(Func.parseStr(map.get("title")));
        info.setDataType(Func.parseStr(map.get("dataType")));
        info.setRemark(Func.parseStr(map.get("remark")));
        info.setFileName(fileName);
        info.setFileType(fileType);
        info.setFileUrl(fileUrl);
        info.setFilePath(filePath);
        info.setCreateTime(new Date());
        info.setFileSize(Func.parseStr(file.getSize()));

        file.transferTo(dest); //保存文件
        fileInfoMapper.addFileInfo(info);
        return info;
    }


    @Override
    public List<FileInfo> selectPage() throws Exception {
        return fileInfoMapper.selectFileList();
    }

    @Override
    public List<FileInfo> getListPage(FileInfo info) throws Exception {
        return fileInfoMapper.getListPage(info);
    }

    @Override
    public int getTotal(FileInfo info) throws Exception {
        return fileInfoMapper.getTotal(info);
    }

    @Override
    public void deleteInfoById(String id) throws Exception {
        fileInfoMapper.deleteByPrimaryKey(id);
    }
}

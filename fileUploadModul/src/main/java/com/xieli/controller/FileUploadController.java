package com.xieli.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xieli.entity.FileInfo;
import com.xieli.service.FileService;
import com.xieli.utils.Func;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FileUploadController {
    private static Logger logger = LogManager.getLogger(FileUploadController.class);

    @Autowired
    private FileService fileService;

    @RequestMapping(value="/uploadFile",produces="application/json;charset=UTF-8")
    public ModelAndView uploadFile(@RequestParam("fileName") MultipartFile fileName, HttpServletRequest request) {
        try {
            Map map = new HashMap();
            map.put("title", Func.parseStr(request.getParameter("title")));
            map.put("dataType", Func.parseStr(request.getParameter("dataType")));
            map.put("remark", Func.parseStr(request.getParameter("remark")));
            FileInfo info = fileService.insertFileInfo(fileName, map);
            ModelAndView model = new ModelAndView();
            model.setViewName("info");
            model.addObject("info", info);
            return model;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping("/selectPage")
    public String selectPage(HttpServletRequest request){
        try {
            List<FileInfo> fileInfos= fileService.selectPage();
//            logger.trace("trace查询了学生信息");
//            logger.info("info查询了学生信息");
//            logger.warn("warn查询了学生信息");
//            logger.error("erro查询了学生信息");
//            logger.debug("debug查询了学生信息");
            System.out.println("-----------------------------log2-------------------------------------------");
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("total", fileInfos.size());
            jsonObj.put("rows", fileInfos);
            return jsonObj.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
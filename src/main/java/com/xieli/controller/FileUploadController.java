package com.xieli.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.xieli.entity.FileInfo;
import com.xieli.service.FileService;
import com.xieli.utils.Func;
import com.xieli.utils.PageHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* *
 * @description 文件上传contorller
 * @author xieli
 * @date  17:45 2019/7/19
 * @param
 * @return
 **/
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

    /* *
     * @description 假分页
     * @author xieli
     * @date  17:44 2019/7/19
     * @param [request]
     * @return java.lang.String
     **/
    @RequestMapping("/selectPage")
    public String selectPage(HttpServletRequest request){
        try {
            List<FileInfo> fileInfos= fileService.selectPage();
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


    /* *
     * @description 真分页
     * @author xieli
     * @date  1:46 2019/7/18
     * @param [user, request]
     * @return com.xieli.utils.PageHelper<com.xieli.entity.FileInfo>
     **/
    @RequestMapping("/getListPage")
    public PageHelper<FileInfo> getUserListPage(FileInfo info, HttpServletRequest request) {
        try {
            PageHelper<FileInfo> pageHelper = new PageHelper<FileInfo>();
            // 统计总记录数
            int total = fileService.getTotal(info);
            pageHelper.setTotal(total);

            // 查询当前页实体对象
            List<FileInfo> list = fileService.getListPage(info);
            pageHelper.setRows(list);

            return pageHelper;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new PageHelper<>();
    }

    /* *
     * @description 真分页
     * @author xieli
     * @date  1:46 2019/7/18
     * @param [user, request]
     * @return com.xieli.utils.PageHelper<com.xieli.entity.FileInfo>
     **/
    @RequestMapping("/getListPagePlugin")
    public PageHelper<FileInfo> getListPagePlugin(FileInfo info, HttpServletRequest request) {
        try {
            PageHelper<FileInfo> pageHelper = new PageHelper<FileInfo>();
            // 统计总记录数
            int total = fileService.getTotal(info);
            pageHelper.setTotal(total);

            com.github.pagehelper.PageHelper.startPage(info.getPage(), info.getLimit());
            // 查询当前页实体对象
            List<FileInfo> list= fileService.selectPage();
//            PageInfo pageInfo =  new PageInfo(list);
            pageHelper.setRows(list);

            return pageHelper;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new PageHelper<>();
    }

    @RequestMapping("/deleteInfoById/{objid}")
    public void deleteInfoById(@PathVariable String objid, Model model)
    {
        try {
            if (Func.checkNullOrEmpty(objid))
                return;
            fileService.deleteInfoById(objid);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ;

    }



}
package com.huai.web.controller;


import com.huai.web.DataSetException;
import com.huai.web.pojo.DataSet;
import com.huai.web.pojo.Relationship;
import com.huai.web.pojo.Result;
import com.huai.web.service.ExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by liangyh on 3/12/17.
 */
@Controller
@RequestMapping(value = "/data")
public class ExecutionController {

    @Autowired
    private ExecutionService executionService;

    @ResponseBody
    @RequestMapping(value = "/dataSet")
    public Result showDataSet(HttpServletRequest request) throws IllegalStateException, IOException {

        Result result = new Result();
        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            //only one file
            if(iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                try {
                    result.setData(executionService.parseDataSet(file.getInputStream()));
                    result.setGood(true);
                    return result;
                } catch (DataSetException e) {
                    e.printStackTrace();
                    result.setData(e.getMessage().toString());
                    return result;
                }
            }
        }
        result.setData("something wrong!");
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/resultSet")
    public String processResultSet(HttpServletRequest request) throws IllegalStateException, IOException {
        Result judgeResult = null;
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            if(iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile dataSetFile = multiRequest.getFile(iter.next().toString());
                if(iter.hasNext()){
                    MultipartFile resultSetFile = multiRequest.getFile(iter.next().toString());
                    judgeResult = executionService.judgeResultSet(dataSetFile.getInputStream(), resultSetFile.getInputStream());
                    if(judgeResult.isGood()){
                        return judgeResult.getData().toString();
                    }
                }
            }
        }
        if(judgeResult == null) return "Please try again!";
        else{
            return "A little problem : "+judgeResult.getData().toString();
        }
    }
}

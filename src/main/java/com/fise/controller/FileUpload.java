package com.fise.controller;

import com.fise.common.SimpleResponse;
import com.sun.deploy.net.HttpResponse;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

/**
 * @author tongch -Administrator
 * @version 1.0
 * @classname FileUpload
 * @date 2019/07/17 22:31
 * @description
 **/
@Slf4j
@Controller
@RequestMapping("/upload")
public class FileUpload {
    
    @RequestMapping("/index.do")
    public String upIndex(){
        return  "test";
    }
    
    @RequestMapping("/up.do")
    @ResponseBody//设置返回一个非页面
    public SimpleResponse upLoadFile(@RequestParam("upFile") MultipartFile file){
        if (file.isEmpty()){
            return SimpleResponse.builder().message("up.do").type(SimpleResponse.Type.SUCCESSFUL).build();
        }
        String fileName = file.getOriginalFilename();
        String filePath = System.getProperty("user.dir");
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            log.info("上传成功");
            return SimpleResponse.builder().message("up.do").type(SimpleResponse.Type.SUCCESSFUL).build();
        } catch (IOException e) {
            log.error(e.toString(), e);
        }finally {
            return SimpleResponse.builder().message("up.do").type(SimpleResponse.Type.EXCEPTION).build();
        }
    }
    
    @ResponseBody
    @RequestMapping("/down.do")
    public SimpleResponse downFile(){
        return SimpleResponse.builder().message("down.do").type(SimpleResponse.Type.FAILED).build();
    }
}

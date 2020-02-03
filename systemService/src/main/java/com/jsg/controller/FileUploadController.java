package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: wyx
 * @Date: 2019-04-08 10:13
 * @Description:
 */

@Controller
public class FileUploadController {
    private String url = "/cdss/system-api/pictures/";

    /**
     * @param file 上传的文件
     * @return
     */
    @ResponseBody
    @RequestMapping("/fileUpload")
    public ResultBase upload(@RequestParam("file") MultipartFile file) {
        //1定义要上传文件 的存放路径
        String localPath = "/root/photo";
        //2获得文件名字
        String fileName = file.getOriginalFilename();
        //2上传失败提示
        String warning = "";
        String newFileName = FileUtils.upload(file, localPath, fileName);
        if (newFileName != null) {
            //上传成功
            warning = "successful";

        } else {
            warning = "failure";
        }
        System.out.println(warning);
        String newUrl = url + newFileName;
        return ResultUtil.success("successful", newUrl);
    }

}


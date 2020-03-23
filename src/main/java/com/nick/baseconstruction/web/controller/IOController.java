package com.nick.baseconstruction.web.controller;

import com.nick.baseconstruction.common.constants.ErrorCode;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("/io")
public class IOController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 下载文件
     */
    @ResponseBody
    @RequestMapping("/download")
    public String download(HttpServletRequest request, HttpServletResponse response){
        try {
            File file = new File("D:\\0309","组件组任务计划表.xlsx");
            if(!file.exists()||file.isDirectory()){
                logger.error("File is not Exist!");
            }
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("content-disposition","attachment;filename="  +  URLEncoder.encode(file.getName(),  "UTF-8"));
            InputStream is = null;
            BufferedInputStream bis = null;
            OutputStream os = null;
            BufferedOutputStream bos = null;
            try {
                is = new FileInputStream(file);
                bis = new BufferedInputStream(is);
                byte[] data = new byte[1024];
                int bytes = 0;
                os = response.getOutputStream();
                bos = new BufferedOutputStream(os);
                while((bytes = bis.read(data,0,data.length))!= -1){
                    bos.write(data,0,bytes);
                }
                bos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null){
                        is.close();
                    }
                    if (bis != null){
                        bis.close();
                    }
                    if (os != null){
                        os.close();
                    }
                    if (bos != null){
                        bos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return ErrorCode.SUCCESS_CODE;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return  ErrorCode.ERROR_CODE;
        }
    }


    /**
     * 上传文件
     */
    @ResponseBody
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile[] files){
        try {
            for(MultipartFile file:files){
                String originalFilename = file.getOriginalFilename();
                System.out.println(originalFilename);
                String contentType = file.getContentType();
                System.out.println(contentType);
                File file1 = new File("D:\\0309",originalFilename);
                if(!file1.getParentFile().exists()){
                    file1.getParentFile().mkdir();
                }
                //file.transferTo(file1);
                FileUtils.copyInputStreamToFile(file.getInputStream(),file1);
            }
            return ErrorCode.SUCCESS_CODE;
        } catch (IOException e) {
            e.printStackTrace();
            return ErrorCode.ERROR_CODE;
        }
    }

}

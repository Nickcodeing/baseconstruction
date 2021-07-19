package com.nick.baseconstruction.web.controller;

import com.nick.baseconstruction.common.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/date")
public class DateController {


    @ResponseBody
    @RequestMapping("/getCurrentTime")
    public String method(){
        String currentTime = DateUtils.getCurrentTime();
        System.out.println(currentTime);
        return currentTime;
    }


    @ResponseBody
    @RequestMapping("/getTime/Test")
    public String method1(){
        String currentTime = DateUtils.getCurrentTime();
        System.out.println(currentTime);
        return currentTime;
    }
}

package com.nick.baseconstruction.web.index;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseGroundController {

    @RequestMapping("")
    public String initIndex(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/error")
    public String error(){
        return "error2";
    }

    @RequestMapping("/error2")
    public String error2(){
        return "error";
    }
}

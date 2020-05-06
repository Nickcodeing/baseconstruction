package com.nick.baseconstruction.web.controller.swaggerTest;


import com.nick.baseconstruction.web.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/swaggerTest/")
@Api(tags = {"swaggerTest"},description = "swaggerTest测试类")
public class swaggerController {

    @RequestMapping("/test")
    @ResponseBody
    @ApiOperation(value = "测试一", httpMethod = "POST", notes = "")
    public String method(@ApiParam(value = "users",required = true)@RequestBody User user){
        return "success !";
    }



}

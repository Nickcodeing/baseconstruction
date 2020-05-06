package com.nick.baseconstruction.web.controller;


import com.nick.baseconstruction.web.entity.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testForConfig")
@Api(tags = {"config"},description = "配置文件测试")
public class TestForInterfaceConfigurationController {

    @Autowired
    private Person person;

    @RequestMapping("getPersonProperties")
    @ApiOperation(value = "测试方法", httpMethod = "POST")
    public String getPerson(){
        String name = person.getName();
        String age = person.getAge();
        String sex = person.getSex();
        return "name:"+name+",age:"+age+",sex:"+sex;
    }


}

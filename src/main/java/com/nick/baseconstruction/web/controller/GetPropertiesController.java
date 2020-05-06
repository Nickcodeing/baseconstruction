package com.nick.baseconstruction.web.controller;

import com.nick.baseconstruction.common.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RestController
public class GetPropertiesController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/test/properties")
    public void getProperties(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("getProperties Exception:",e);
        }
        String property = properties.getProperty("spring.servlet.context-path","hjdf");
        System.out.println(property);
        String port = properties.getProperty("server.port", "2000");
        System.out.println(port);

    }

    @RequestMapping("/test/getPro")
    public String getPro(String properties){
        String property = new PropertiesUtil().getProperties("application.properties", properties);
        return property;
    }




}

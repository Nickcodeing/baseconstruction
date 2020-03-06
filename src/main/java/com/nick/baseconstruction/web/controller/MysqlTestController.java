package com.nick.baseconstruction.web.controller;

import com.nick.baseconstruction.common.constants.ErrorCode;
import com.nick.baseconstruction.web.entity.User;
import com.nick.baseconstruction.web.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
@RequestMapping("/mysql")
@CrossOrigin
public class MysqlTestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/testInsert")
    public String insertMember( User user){
        try {
            user.setCreateTime(new Date());
            userService.insert(user);
            return ErrorCode.SUCCESS_CODE;
        } catch (Exception e) {
            logger.error("insertMember Exception:",e);
            return ErrorCode.ERROR_CODE;
        }
    }




}

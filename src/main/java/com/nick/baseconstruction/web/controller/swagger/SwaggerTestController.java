package com.nick.baseconstruction.web.controller.swagger;


import com.nick.baseconstruction.common.constants.ErrorCode;
import com.nick.baseconstruction.web.entity.User;
import com.nick.baseconstruction.web.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/swagger")
@Api(tags = {"swagger"},description = "swagger测试类")
public class SwaggerTestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @RequestMapping("test1")
    @ResponseBody
    @ApiOperation(value = "测试方法一",notes = "参数记得写user",httpMethod = "POST")
    @Transactional
    public String method1(@ApiParam(value = "user",required = true)@RequestBody User user){
        try {
            userService.insert(user);
            System.out.println(1/0);
            return ErrorCode.SUCCESS_CODE;
        } catch (Exception e) {
            logger.error("method1 Exception:",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ErrorCode.ERROR_CODE;
        }
    }
}

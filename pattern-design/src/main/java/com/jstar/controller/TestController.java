package com.jstar.controller;

import com.jstar.bean.ProcessContext;
import com.jstar.bean.ProcessRequest;
import com.jstar.engine.UserInfoProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/23 21:18
 */

@RestController
public class TestController {

    @Autowired
    UserInfoProcessEngine userInfoProcessEngine;


    @GetMapping("hello")
    public String Hello() {

        ProcessContext processContext = new ProcessContext();
        ProcessRequest processRequest = new ProcessRequest();
        userInfoProcessEngine.start(processRequest, processContext);
        return "hello";
    }

}

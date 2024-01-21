package com.jstar.processor;

import com.jstar.Repository.UserInfoRepository;
import com.jstar.bean.ProcessContext;
import com.jstar.bean.ProcessRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/23 22:08
 */
@Component
public class ConsumerProcessor implements Processor {


    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public boolean needExecute(ProcessRequest request, ProcessContext context) {
        return true;
    }

    @Override
    public void execute(ProcessRequest request, ProcessContext context) {
        System.out.println(userInfoRepository.getUserInfo("1"));
    }
}

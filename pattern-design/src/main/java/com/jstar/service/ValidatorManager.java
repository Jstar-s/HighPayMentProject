package com.jstar.service;

import com.jstar.bean.TransferRequest;
import com.jstar.validate.ParamValidator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/24 16:28
 */
@Service
public class ValidatorManager implements InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;

    private List<ParamValidator> validatorList = new ArrayList<>();

    @Override
    public void afterPropertiesSet() throws Exception {

        Map<String, ParamValidator> paramValidatorMap = applicationContext.getBeansOfType(ParamValidator.class);

        validatorList = new ArrayList<>(paramValidatorMap.values());
    }


    public void checkParam(TransferRequest request) {

        for (ParamValidator paramValidator : validatorList) {
            paramValidator.checkParam(request);
        }

    }

}

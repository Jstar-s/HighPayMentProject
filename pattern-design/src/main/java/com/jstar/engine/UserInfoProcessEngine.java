package com.jstar.engine;

import com.jstar.Enum.ProcessNameEnum;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/23 22:29
 */

@Component
public class UserInfoProcessEngine extends AbstractProcessEngineImpl {


    @Override
    protected List<ProcessNameEnum> getProcessors() {
        return Arrays.asList(ProcessNameEnum.USER_INFO_PROCESSOR);
    }
}

package com.jstar.engine;

import com.jstar.Enum.ProcessNameEnum;
import com.jstar.bean.ProcessContext;
import com.jstar.bean.ProcessRequest;
import com.jstar.processor.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/23 22:16
 */
@Component
public abstract class AbstractProcessEngineImpl implements ProcessEngine {


    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void start(ProcessRequest request, ProcessContext context) {


        List<ProcessNameEnum> processors = getProcessors();

        try {
            processors.forEach( processName -> {
                Object bean = applicationContext.getBean(processName.getName());
                if (bean instanceof Processor) {
                    Processor processor = (Processor) bean;
                    if (processor.needExecute(request, context)) {
                        processor.execute(request, context);
                        System.out.println("execute processor");
                    }
                }
            });


        } catch (Exception e) {



        }


    }


    protected abstract List<ProcessNameEnum> getProcessors();
}

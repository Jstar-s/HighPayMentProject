package com.jstar.engine;

import com.jstar.bean.ProcessContext;
import com.jstar.bean.ProcessRequest;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/23 22:15
 */
public interface ProcessEngine {



    void start(ProcessRequest request, ProcessContext context);
}

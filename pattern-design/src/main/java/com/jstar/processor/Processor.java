package com.jstar.processor;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/23 22:03
 */

import com.jstar.bean.ProcessContext;
import com.jstar.bean.ProcessRequest;

/**
 * 处理器 执行一个功能
 */
public interface Processor {


    boolean needExecute(ProcessRequest request, ProcessContext context);



    void execute(ProcessRequest request, ProcessContext context);



}

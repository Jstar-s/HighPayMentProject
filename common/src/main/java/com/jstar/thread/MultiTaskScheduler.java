package com.jstar.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/8/2 21:10
 */

// final class 是设计的不能被继承的类，它具有安全性、性能优化和API设计方面的优势。
@Component
public final class MultiTaskScheduler {
    private static final Logger looger = LoggerFactory.getLogger(MultiTaskScheduler.class);

    /*
    * 配置线程池参数
    * */
    private static long keepAliveTime;
    private static int queueCapacity;

    private static int corePoolSize;





}

package com.jstar.monitor;

import com.jstar.bean.TransferResult;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/24 17:08
 */

@Service
public class TransferSubject implements InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;

    private final List<TransferObserver> transferObserverList = new ArrayList<>();

    //异步线程池，监控操作不影响主业务
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, TransferObserver> transferObserverMap = applicationContext.getBeansOfType(TransferObserver.class);
        transferObserverMap.values().forEach(this::addObserver);
    }


    public void notifyObserver(TransferResult transferResult) {

        transferObserverList.forEach( transferObserver -> {
            executorService.execute(() -> {
                transferObserver.update(transferResult);
            });
        });
    }



    public void addObserver(TransferObserver transferObserver) {transferObserverList.add(transferObserver); }
}

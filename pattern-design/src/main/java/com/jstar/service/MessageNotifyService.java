package com.jstar.service;

import org.springframework.stereotype.Service;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/24 16:41
 */
@Service
public class MessageNotifyService  implements  NotifyService{
    @Override
    public void notifyMessage(String userId, String content) {
        System.out.println("短信通知");
    }
}





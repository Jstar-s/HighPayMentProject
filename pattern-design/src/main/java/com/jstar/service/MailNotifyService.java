package com.jstar.service;

import org.springframework.stereotype.Service;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/24 16:40
 */


@Service
public class MailNotifyService implements  NotifyService{
    @Override
    public void notifyMessage(String userId, String content) {
        System.out.println("邮件通知");
    }
}

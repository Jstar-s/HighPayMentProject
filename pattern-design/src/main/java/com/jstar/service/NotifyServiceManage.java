package com.jstar.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/24 16:42
 */
@Service
public class NotifyServiceManage implements InitializingBean {

    @Autowired
    private MailNotifyService mailNotifyService;

    @Autowired
    private MessageNotifyService messageNotifyService;

    private final Map<NotifyEnum, NotifyService> notifyServiceMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        notifyServiceMap.put(NotifyEnum.MAIL, mailNotifyService);
        notifyServiceMap.put(NotifyEnum.MESSAGE, messageNotifyService);

    }


    public void notify(NotifyEnum notifyEnum, String userId, String content ) {

        NotifyService notifyService = notifyServiceMap.get(notifyEnum);
        if (notifyService == null) {
            throw new RuntimeException("notify service don't exist ");
        }
        notifyService.notifyMessage(userId, content);
    }


    public enum NotifyEnum {
        MAIL,
        MESSAGE
    }



}

package com.jstar.service;

import com.jstar.bean.TransferOut;
import com.jstar.bean.TransferRequest;
import com.jstar.bean.TransferResult;
import com.jstar.bean.notify.UserInfo;
import com.jstar.config.NotifyClient;
import com.jstar.monitor.TransferSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/24 16:13
 */
@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    ValidatorManager validatorManager;

    @Autowired
    NotifyServiceManage notifyServiceManage;

    @Autowired
    TransferSubject transferSubject;

    @Autowired
    UserService userService;

    @Autowired
    NotifyClient notifyClient;


    @Autowired
    BillService billService;

    @Autowired
    monitorService monitorService;

    @Autowired
    quotaService quotaService;


    @Override
    public TransferOut transfer(TransferRequest request) {

        // 参数校验
        /**
         * 优点新增校验无需修改transfer方法
         * 使用了责任链模式
         */
        validatorManager.checkParam(request);


        // 转账服务
        TransferResult transferResult = transferMoney(request);

        if (!transferResult.isSuccess()) {
            return null;
        }

        // 通知用户
        /**
         * 新增通知方式不用修改trasfer
         * 适配器模式
         */
        notifyServiceManage.notify(request.getNotifyType(), request.getUser(), request.getContent());


        // 监控订单情况
        /**
         * 观察者模式
         */
        transferSubject.notifyObserver(transferResult);


        return new TransferOut();
    }

    @Override
    public boolean transferFirst(String user, String money, String payee) {
        // 参数校验
        if(isValidUser(user) || !isValidMoney(money) || isValidPayee(payee)) {
            return false;
        }

        // 转账服务
        TransferResult transferResult = transferMoney(user, money, payee);
        if (!transferResult.isSuccess()) {
            return false;
        }

        // 通知用户
        UserInfo userInfo = userService.getUserInfo(user);
        if (userInfo.getNotifyType().equals(NotifyServiceManage.NotifyEnum.MAIL)) {
            notifyClient.sendMail(user);
        } else if (userInfo.getNotifyType().equals(NotifyServiceManage.NotifyEnum.MESSAGE)) {
            notifyClient.sendMessage(user);
        }

        // 记录转账账单
        billService.sendBill(transferResult);
        // 转账监控打点
        monitorService.sendRecord(transferResult);
        // 记录转账额度
        quotaService.recordQuota(transferResult);

        return true;
    }

    private boolean isValidPayee(String payee) {
        return true;
    }

    private boolean isValidMoney(String money) {
        return true;
    }

    private boolean isValidUser(String user) {

        return true;
    }

    private TransferResult transferMoney(TransferRequest request) {
        return new TransferResult();
    }

    private TransferResult transferMoney(String user, String money, String payee) {
        return new TransferResult();
    }
}
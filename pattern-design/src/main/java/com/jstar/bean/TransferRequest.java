package com.jstar.bean;

import com.jstar.service.NotifyServiceManage;
import lombok.Data;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/24 16:19
 */

@Data
public class TransferRequest {

    private String user;

    private String money;

    private String payee;

    private String content;

    private NotifyServiceManage.NotifyEnum notifyType;


}

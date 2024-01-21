package com.jstar.bean.notify;

import com.jstar.service.NotifyServiceManage;
import lombok.Data;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/26 22:12
 */
@Data
public class UserInfo {

    private NotifyServiceManage.NotifyEnum notifyType;

}

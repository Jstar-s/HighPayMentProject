package com.jstar.monitor;

import com.jstar.bean.TransferRequest;
import com.jstar.bean.TransferResult;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/24 17:06
 */
public interface TransferObserver {


    void  update(TransferResult transferResult);

}

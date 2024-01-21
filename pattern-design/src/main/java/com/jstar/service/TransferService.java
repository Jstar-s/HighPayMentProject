package com.jstar.service;

import com.jstar.bean.TransferOut;
import com.jstar.bean.TransferRequest;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/24 16:13
 */
public interface TransferService {

    TransferOut transfer(TransferRequest transferRequest);

    boolean transferFirst(String user, String money, String payee);

}

package com.jstar.controller;

import com.jstar.bean.ResponseModel;
import com.jstar.bean.TransferOut;
import com.jstar.bean.TransferRequest;
import com.jstar.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/24 16:03
 */

@RestController
public class TransferController {

    @Autowired
    TransferService transferService;


    @GetMapping("transferFirst")
    public ResponseModel<Boolean> transferFirst(String user, String money, String payee) {
        boolean transfer = transferService.transferFirst(user, money, payee);
        return ResponseModel.success(transfer);
    }


    @GetMapping("transfer")
    public ResponseModel<TransferOut> transfer(TransferRequest request) {
        TransferOut transfer = transferService.transfer(request);
        return ResponseModel.success(transfer);
    }




}

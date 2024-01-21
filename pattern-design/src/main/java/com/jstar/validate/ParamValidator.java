package com.jstar.validate;

import com.jstar.bean.TransferRequest;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/24 16:19
 */
public interface ParamValidator {

    void checkParam(TransferRequest transferRequest);

}

package com.jstar.service;

import com.jstar.bean.notify.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/26 22:13
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserInfo getUserInfo(String user) {
        return new UserInfo();
    }
}

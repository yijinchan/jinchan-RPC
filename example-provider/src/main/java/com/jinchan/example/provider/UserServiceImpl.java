package com.jinchan.example.provider;

import com.jinchan.example.common.model.User;
import com.jinchan.example.common.service.UserService;

public class UserServiceImpl implements UserService {
    /**
     * 获取用户
     * @param user
     * @return
     */
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}

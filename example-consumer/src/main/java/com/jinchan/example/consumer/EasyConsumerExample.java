package com.jinchan.example.consumer;

import com.jinchan.chanrpc.proxy.ServiceProxyFactory;
import com.jinchan.example.common.model.User;
import com.jinchan.example.common.service.UserService;

/**
 *  消费者示例
 */
public class EasyConsumerExample {
    public static void main(String[] args) {
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("jinchan");
        //调用
        User newUser = userService.getUser(user);
        if(newUser != null) {
            System.out.println("newUser name is " + newUser.getName());
        } else {
            System.out.println("newUser is null");
        }
    }
}

package com.jinchan.example.consumer;

import com.jinchan.chanrpc.proxy.ServiceProxyFactory;
import com.jinchan.example.common.model.User;
import com.jinchan.example.common.service.UserService;

/**
 * ClassName: ConsumerExample
 * Package: com.jinchan.example.consumer
 * Description:
 *
 * @Author yijinchan
 * @Create 2024/3/5 17:21
 */
public class ConsumerExample {
    public static void main(String[] args) {
        //获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("jinchan");
        //调用服务
        User newUser = userService.getUser(user);
        if(newUser != null) {
            System.out.println("姓名:" + newUser.getName());
        } else {
            System.out.println("姓名:null");
        }
        long number = userService.getNumber();
        System.out.println("数字:" + number);
    }
}

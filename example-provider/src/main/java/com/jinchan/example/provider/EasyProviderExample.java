package com.jinchan.example.provider;

import com.jinchan.chanrpc.registry.LocalRegistry;
import com.jinchan.chanrpc.server.HttpServer;
import com.jinchan.chanrpc.server.VertxHttpServe;
import com.jinchan.example.common.service.UserService;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {
    public static void main(String[] args) {
        //注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        //启动服务
        HttpServer httpServer = new VertxHttpServe();
        httpServer.doStart(8080);
    }
}

package com.jinchan.example.provider;

import com.jinchan.chanrpc.RpcApplication;
import com.jinchan.chanrpc.registry.LocalRegistry;
import com.jinchan.chanrpc.server.HttpServer;
import com.jinchan.chanrpc.server.VertxHttpServer;
import com.jinchan.example.common.service.UserService;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {
    public static void main(String[] args) {
        //初始化RPC框架
        RpcApplication.init();

        //注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        //启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPost());
    }
}

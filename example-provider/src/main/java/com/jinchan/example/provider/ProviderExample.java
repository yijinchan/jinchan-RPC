package com.jinchan.example.provider;

import com.jinchan.chanrpc.RpcApplication;
import com.jinchan.chanrpc.config.RegistryConfig;
import com.jinchan.chanrpc.config.RpcConfig;
import com.jinchan.chanrpc.model.ServiceMetaInfo;
import com.jinchan.chanrpc.registry.LocalRegistry;
import com.jinchan.chanrpc.registry.Registry;
import com.jinchan.chanrpc.registry.RegistryFactory;
import com.jinchan.chanrpc.server.tcp.VertxTcpServer;
import com.jinchan.example.common.service.UserService;

/**
 * ClassName: ProviderExample
 * Package: com.jinchan.example.provider
 * Description:
 *
 * @Author yijinchan
 * @Create 2024/4/6 16:35
 */
public class ProviderExample {
    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 TCP 服务
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(8080);
    }
}

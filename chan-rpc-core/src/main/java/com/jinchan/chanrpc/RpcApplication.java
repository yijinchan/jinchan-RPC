package com.jinchan.chanrpc;

import com.jinchan.chanrpc.config.RegistryConfig;
import com.jinchan.chanrpc.config.RpcConfig;
import com.jinchan.chanrpc.constant.RpcConstant;
import com.jinchan.chanrpc.registry.Registry;
import com.jinchan.chanrpc.registry.RegistryFactory;
import com.jinchan.chanrpc.utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName: RpcApplication
 * Package: com.jinchan.chanrpc
 * Description:
 *
 * @Author yijinchan
 * @Create 2024/3/5 17:08
 */
@Slf4j
public class RpcApplication {
    private static volatile RpcConfig rpcConfig;

    /**
     * 框架初始化，支持传入自定义配置
     * @param newRpcConfig
     */
    public static void init(RpcConfig newRpcConfig) {
        rpcConfig = newRpcConfig;
        log.info("初始化配置信息：{}", newRpcConfig.toString());
        //注册中心初始化
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        registry.init(registryConfig);
        log.info("register init, config = {}",registryConfig);
    }

    public static void init() {
        RpcConfig newRpcConfig;
        try {
            newRpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            //配置加载失败，使用默认配置
            newRpcConfig = new RpcConfig();
        }
        init(newRpcConfig);
    }

    /**
     *  获取配置
     * @return
     */
    public static RpcConfig getRpcConfig() {
        if (rpcConfig == null) {
            synchronized (RpcApplication.class) {
                if (rpcConfig == null) {
                    init();
                }
            }
        }
        return rpcConfig;
    }

}

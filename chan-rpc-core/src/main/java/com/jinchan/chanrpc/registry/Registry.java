package com.jinchan.chanrpc.registry;

/**
 * ClassName: Registry
 * Package: com.jinchan.chanrpc.register
 * Description:
 *
 * @Author yijinchan
 * @Create 2024/4/3 20:46
 */

import com.jinchan.chanrpc.config.RegistryConfig;
import com.jinchan.chanrpc.model.ServiceMetaInfo;

import java.util.List;

/**
 * 注册中心
 */
public interface Registry {
    /**
     *  初始化
     * @param registryConfig
     */
    void init(RegistryConfig registryConfig);

    /**
     * 注册服务（服务端）
     * @param serviceMetaInfo
     */
    void register(ServiceMetaInfo serviceMetaInfo) throws Exception;

    /**
     * 注销服务（服务端）
     * @param serviceMetaInfo
     */
    void unRegister(ServiceMetaInfo serviceMetaInfo);

    /**
     * 服务发现（获取某服务的所有节点，客户端）
     * @param serviceKey
     * @return
     */
    List<ServiceMetaInfo> serviceDiscovery(String serviceKey);

    /**
     * 服务校徽
     */
    void destroy();
}

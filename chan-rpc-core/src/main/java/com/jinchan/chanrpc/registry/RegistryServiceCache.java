package com.jinchan.chanrpc.registry;

import com.jinchan.chanrpc.model.ServiceMetaInfo;

import java.util.List;

/**
 * ClassName: RegistryServiceCache
 * Package: com.jinchan.chanrpc.registry
 * Description:
 * 注册中心服务本地缓存
 *
 * @Author yijinchan
 * @Create 2024/4/15 10:49
 */
public class RegistryServiceCache {

    /**
     * 服务缓存
     */
    List<ServiceMetaInfo> serviceCache;

    /**
     * 写缓存
     *
     * @param newServiceCache
     */
    void writeCache(List<ServiceMetaInfo> newServiceCache) {
        this.serviceCache = newServiceCache;
    }

    /**
     * 读缓存
     * @return
     */
    List<ServiceMetaInfo> readCache() {
        return this.serviceCache;
    }
    /**
     * 清空缓存
     */
    void clearCache(){
        this.serviceCache = null;
    }
}

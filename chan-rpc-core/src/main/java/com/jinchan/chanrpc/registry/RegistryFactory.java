package com.jinchan.chanrpc.registry;

import com.jinchan.chanrpc.spi.SpiLoader;

/**
 * ClassName: RegistryFactory
 * Package: com.jinchan.chanrpc.register
 * Description:
 * 注册中心工厂（用于获取注册中心对象）
 *
 * @Author yijinchan
 * @Create 2024/4/5 22:48
 */
public class RegistryFactory {

    static {
        SpiLoader.load(Registry.class);
    }

    /**
     * 默认注册中心
     */
    private static final Registry DEFAULT_REGISTRY = new EtcdRegistry();

    /**
     * 根据key获取注册中心
     * @param key
     * @return
     */
    public static Registry getInstance(String key){
        return SpiLoader.getInstance(Registry.class, key);
    }
}

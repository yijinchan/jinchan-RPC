package com.jinchan.chanrpc.config;

import lombok.Data;

/**
 * ClassName: RegistryConfig
 * Package: com.jinchan.chanrpc.config
 * Description:
 *
 * @Author yijinchan
 * @Create 2024/4/3 20:40
 */
@Data
public class RegistryConfig {
    /**
     * 注册中心类型
     */
    private String registry = "etcd";
    /**
     * 注册中心地址
     */
    private String address = "http://localhost:2379";
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 超时时间（ms）
     */
    private long timeout = 10000L;
}

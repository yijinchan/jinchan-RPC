package com.jinchan.chanrpc.config;

import lombok.Data;

/**
 * ClassName: RpcConfig
 * Package: com.jinchan.chanrpc.config
 * Description:
 * RRC框架配置
 *
 * @Author yijinchan
 * @Create 2024/3/5 16:51
 */
@Data
public class RpcConfig {
    /**
     * 服务名
     */
    private String name = "chan-rpc";
    /**
     * 版本好
     */
    private String version = "1.0";
    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";
    /**
     * 服务器端口号
     */
    private Integer serverPost = 8080;
    /**
     * 模拟调用
     */
    private boolean mock = false;
}

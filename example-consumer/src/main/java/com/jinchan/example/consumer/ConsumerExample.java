package com.jinchan.example.consumer;

import com.jinchan.chanrpc.config.RpcConfig;
import com.jinchan.chanrpc.utils.ConfigUtils;

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
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
    }
}

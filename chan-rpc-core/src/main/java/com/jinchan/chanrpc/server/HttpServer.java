package com.jinchan.chanrpc.server;

/**
 * Http服务器接口
 */
public interface HttpServer {
    /**
     * 启动服务器
     * @param port
     */
    void doStart(int port);
    //todo 可以考虑实现netty作为web服务器
}

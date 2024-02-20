package com.jinchan.chanrpc.server;

import io.vertx.core.Vertx;

/**
 * Vertx Http 服务器
 */
public class VertxHttpServe implements HttpServer {
    /**
     * 启动服务器
     * @param port
     */
    @Override
    public void doStart(int port) {
        //创建一个vertx实例
        Vertx vertx = Vertx.vertx();
        //创建一个httpserver
        io.vertx.core.http.HttpServer server = vertx.createHttpServer();
        //监听端口并处理请求
        server.requestHandler(new HttpServerHandler());
        //启动HTTP服务并监听指定端口
        server.listen(port, result -> {
            if (result.succeeded()) {
                System.out.println("HTTP server started on port " + port);
            } else {
                System.err.println("Faild to start HTTP server" + result.cause());
            }
        });
    }
}

package com.jinchan.chanrpc.server.tcp;

import io.vertx.core.Vertx;

/**
 * ClassName: VertxTcpClient
 * Package: com.jinchan.chanrpc.server.tcp
 * Description:
 *
 * @Author yijinchan
 * @Create 2024/4/23 15:52
 */
public class VertxTcpClient {
    public void start() {
        //创建Vert.x实例
        Vertx vertx = Vertx.vertx();

        vertx.createNetClient().connect(8888, "localhost", result -> {
            if (result.succeeded()) {
                System.out.println("Connected to TCP server");
                io.vertx.core.net.NetSocket socket = result.result();
                //发送数据
                socket.write("Hello, server!");
                //接收响应
                socket.handler(buffer -> {
                    System.out.println("Received response from server : " + buffer.toString());
                });
            } else {
                System.err.println("Failed to connect to TCP server");
            }
        });
    }

    public static void main(String[] args) {
        new VertxTcpClient().start();
    }
}


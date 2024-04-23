package com.jinchan.chanrpc.server.tcp;

import com.jinchan.chanrpc.server.HttpServer;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetServer;

/**
 * ClassName: VertxTcpServer
 * Package: com.jinchan.chanrpc.server.tcp
 * Description:
 *
 * @Author yijinchan
 * @Create 2024/4/23 15:38
 */
public class VertxTcpServer implements HttpServer {
    private byte[] handleRequest(byte[] requestData) {
        // 处理请求的逻辑，根据requestData 构造响应函数并返回
        return "Hello,client!".getBytes();
    }

    @Override
    public void doStart(int port) {
        //创建Vert.x 实例
        Vertx vertx = Vertx.vertx();
        //创建TCP服务器
        NetServer server = vertx.createNetServer();
        //处理请求
        server.connectHandler(socket -> {
           //处理连接
           socket.handler(buffer -> {
               //处理接收到的字节数组
               byte[] requestData = buffer.getBytes();
               //自定义字节数组处理逻辑，比如解析请求、调用服务、构造响应等
               byte[] responseData = handleRequest(requestData);
               socket.write(Buffer.buffer(responseData));
           });
        });

        //启动TCP服务器并监听指定端口
        server.listen(port, ar -> {
            if (ar.succeeded()) {
                System.out.println("TCP server started on port " + port);
            } else {
                System.out.println("Failed to start TCP server: " + ar.cause().getMessage());
            }
        });
    }

    public static void main(String[] args) {
        new VertxTcpServer().doStart(8888);
    }
}

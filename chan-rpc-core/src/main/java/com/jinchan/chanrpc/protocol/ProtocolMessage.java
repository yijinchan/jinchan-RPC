package com.jinchan.chanrpc.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: ProtocolMessage
 * Package: com.jinchan.chanrpc.protocol
 * Description:
 * 协议消息结构
 * @Author yijinchan
 * @Create 2024/4/16 15:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProtocolMessage<T> {
    /**
     * 消息头
     */
    private Header header;
    /**
     * 消息体
     */
    private T body;

    /**
     * 协议消息头
     */
    @Data
    public static class Header {
        /**
         * 魔数
         */
        private byte magic;
        /**
         * 版本
         */
        private byte version;
        /**
         * 消息类型（请求/响应）
         */
        private byte type;
        /**
         * 状态
         */
        private byte status;
        /**
         * 请求ID
         */
        private long requestId;
        /**
         * 消息体长度
         */
        private int bodyLength;
        /**
         * 序列化方式
         */
        private Byte Serializer;
    }
}

package com.jinchan.chanrpc.constant;

/**
 * ClassName: ProtocolConstant
 * Package: com.jinchan.chanrpc.constant
 * Description:
 *
 * @Author yijinchan
 * @Create 2024/4/16 15:47
 */
public interface ProtocolConstant {
    /**
     * 消息头长度
     */
    int MESSAGE_HEADER_LENGTH = 17;
    /**
     * 协议魔数
     */
    byte PROTOCOL_MAGIC = 0x1;
    /**
     * 协议版本号
     */
    byte PROTOCOL_VERSION = 0x1;
}

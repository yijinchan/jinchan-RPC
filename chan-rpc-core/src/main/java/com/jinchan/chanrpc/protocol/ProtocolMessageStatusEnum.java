package com.jinchan.chanrpc.protocol;

import lombok.Getter;

/**
 * ClassName: ProtocolMessageStatusEnum
 * Package: com.jinchan.chanrpc.protocol
 * Description:
 *
 * @Author yijinchan
 * @Create 2024/4/16 15:50
 */
@Getter
public enum ProtocolMessageStatusEnum {
    OK("ok", 20),
    BAD_REQUEST("badRequest", 40),
    BAD_RESPONSE("badResponse", 50);
    private final String test;
    private final int value;

    ProtocolMessageStatusEnum(String test, int value) {
        this.test = test;
        this.value = value;
    }

    /**
     * 根据value获取枚举
     *
     * @param value
     * @return
     */
    public static ProtocolMessageStatusEnum getEnumByValue(int value) {
        for (ProtocolMessageStatusEnum anEnum : ProtocolMessageStatusEnum.values()) {
            if (anEnum.value == value) {
                return anEnum;
            }
        }
        return null;
    }
}

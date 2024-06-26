package com.jinchan.chanrpc.protocol;

import cn.hutool.core.util.ObjectUtil;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: ProtocolMessageSerializerEnum
 * Package: com.jinchan.chanrpc.protocol
 * Description:
 *
 * @Author yijinchan
 * @Create 2024/4/16 16:13
 */
@Getter
public enum ProtocolMessageSerializerEnum {
    JDK(0, "jdk"),
    JSON(1, "json"),
    KRYO(2, "kryo"),
    HESSIAN(3, "hessian");

    private final int key;
    private final String value;

    ProtocolMessageSerializerEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * 获取所有value
     * @return
     */
    public static List<String> getValues(){
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据key获取枚举
     * @param key
     * @return
     */
    public static ProtocolMessageSerializerEnum getEnumByKey(int key){
        for(ProtocolMessageSerializerEnum anEnum : ProtocolMessageSerializerEnum.values()){
            if (anEnum.key == key) {
                return anEnum;
            }
        }
        return null;
    }

    /**
     * 根据value获取枚举
     * @param value
     * @return
     */
    public static ProtocolMessageSerializerEnum getEnumByValue(String value){
        if (ObjectUtil.isEmpty(value)) {
            return null;
        }
        for(ProtocolMessageSerializerEnum anEnum : ProtocolMessageSerializerEnum.values()){
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }
}

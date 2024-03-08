package com.jinchan.chanrpc.serializer;

import com.jinchan.chanrpc.spi.SpiLoader;

/**
 * ClassName: SerializerFactory
 * Package: com.jinchan.chanrpc.serializer
 * Description:
 * 序列化器工厂
 *
 * @Author yijinchan
 * @Create 2024/3/8 11:22
 */
public class SerializerFactory {
    static {
        SpiLoader.load(Serializer.class);
    }
    /**
     * 默认序列化器
     */
    private static final Serializer DEFAULT_SERIALIZER = new JdkSerializer();

    /**
     *  获取实例
     * @param key
     * @return
     */
    public static Serializer getInstance(String key){
        return SpiLoader.getInstance(Serializer.class,key);
    }
}

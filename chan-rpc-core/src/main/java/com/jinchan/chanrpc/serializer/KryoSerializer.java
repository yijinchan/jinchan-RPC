package com.jinchan.chanrpc.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * ClassName: KryoSerializer
 * Package: com.jinchan.chanrpc.serializer
 * Description:
 * Kryo序列化器
 * @Author yijinchan
 * @Create 2024/3/8 10:58
 */
public class KryoSerializer implements Serializer{
    /**
     * kryo线程不安全，使用ThreadLocal 保证每个线程只有一个Kryo
     */
    private static final ThreadLocal<Kryo> KRYO_THREAD_LOCAL =
            ThreadLocal.withInitial(() ->{
               Kryo kryo = new Kryo();
               //设置动态序列化和反序列化类，不提前注册所有类（可能会有安全问题）
                kryo.setRegistrationRequired(false);
                return kryo;
            });
    @Override
    public <T> byte[] serialize(T object) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Output output = new Output(byteArrayOutputStream);
        KRYO_THREAD_LOCAL.get().writeObject(output,object);
        output.close();
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Input input = new Input(byteArrayInputStream);
        T result = KRYO_THREAD_LOCAL.get().readObject(input,clazz);
        input.close();
        return result;
    }
}

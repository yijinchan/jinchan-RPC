package com.jinchan.chanrpc.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jinchan.chanrpc.model.RpcRequest;
import com.jinchan.chanrpc.model.RpcResponse;

import java.io.IOException;

/**
 * ClassName: JsonSerializer
 * Package: com.jinchan.chanrpc.serializer
 * Description:
 * Json序列化器
 *
 * @Author yijinchan
 * @Create 2024/3/6 14:23
 */
public class JsonSerializer implements Serializer {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     *  Json序列化器
     * @param object
     * @return
     * @param <T>
     * @throws IOException
     */
    @Override
    public <T> byte[] serialize(T object) throws IOException {
        return OBJECT_MAPPER.writeValueAsBytes(object);
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException {
        T object = OBJECT_MAPPER.readValue(bytes, clazz);
        if (object instanceof RpcRequest) {
            return handleRequest((RpcRequest) object, clazz);
        }
        if (object instanceof RpcResponse) {
            return handleResponse((RpcResponse) object, clazz);
        }
        return object;
    }

    /**
     * 由于 0bject 的原始对象会被擦除，导致反序列化时会被作为 LinkedHashMap 无法转
     * 换成原始对象，因此这里做了特殊外理
     * @param rpcRequest
     * @param clazz
     * @return
     * @param <T>
     * @throws IOException
     */
    private <T> T handleRequest(RpcRequest rpcRequest, Class<T> clazz) throws IOException{
        Class<?>[] parameterTypes = rpcRequest.getParameterTypes();
        Object[] args = rpcRequest.getArgs();

        //循环处理每个参数类型
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            //如果类型不同，则重新处理一下类型
            if(!parameterType.isAssignableFrom(args[i].getClass())){
                byte[] bytes = OBJECT_MAPPER.writeValueAsBytes(args[i]);
                args[i] = OBJECT_MAPPER.readValue(bytes,parameterType);
            }
        }
        return clazz.cast(rpcRequest);
    }

    /**
     * 由于 0bject 的原始对象会被擦除，导致反序列化时会被作为 LinkedHashMap 无法转
     * 换成原始对象，因此这里做了特殊外理
     * @param rpcResponse
     * @param clazz
     * @return
     * @param <T>
     * @throws IOException
     */
    private <T> T handleResponse(RpcResponse rpcResponse, Class<T> clazz) throws IOException{
        //处理响应数据
        byte[] bytes = OBJECT_MAPPER.writeValueAsBytes(rpcResponse.getData());
        rpcResponse.setData(OBJECT_MAPPER.readValue(bytes, rpcResponse.getDataType()));
        return clazz.cast(rpcResponse);
    }
}

package com.jinchan.chanrpc.registry;

import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.Client;
import io.etcd.jetcd.KV;
import io.etcd.jetcd.kv.GetResponse;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * ClassName: JetcdRegistry
 * Package: com.jinchan.chanrpc.register
 * Description:
 *
 * @Author yijinchan
 * @Create 2024/4/3 20:12
 */
public class JetcdRegistry {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // create client using endpoints
        Client client = Client.builder().endpoints("http://etcd0:2379", "http://etcd1:2379", "http://etcd2:2379").build();
        KV kvClient = client.getKVClient();
        ByteSequence key = ByteSequence.from("test_key".getBytes());
        ByteSequence value = ByteSequence.from("test_value".getBytes());

        // put the key-value
        kvClient.put(key, value).get();

        // get the CompletableFuture
        CompletableFuture<GetResponse> getFuture = kvClient.get(key);

        // get the value from CompletableFuture
        GetResponse response = getFuture.get();

        // delete the key
        kvClient.delete(key).get();
    }
}

package cn.ice0qw3.netty.rpc.transport.client;

import cn.ice0qw3.netty.rpc.exception.RpcInvokeException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface Future<T> {
    T get() throws InterruptedException, RpcInvokeException;
    T get(long timeout, TimeUnit unit) throws InterruptedException, RpcInvokeException, TimeoutException;
    boolean isDone();

    boolean cancel(boolean removeRequest);


}

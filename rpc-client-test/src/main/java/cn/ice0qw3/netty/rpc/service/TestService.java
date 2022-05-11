package cn.ice0qw3.netty.rpc.service;

import cn.ice0qw3.netty.rpc.annotation.RpcClient;
import cn.ice0qw3.netty.rpc.annotation.RpcReference;
import cn.ice0qw3.netty.rpc.entity.User;
import cn.ice0qw3.netty.rpc.loadbance.LoadBlance;
import cn.ice0qw3.netty.rpc.transport.client.ResponseFuture;

@RpcClient
public interface TestService {

    @RpcReference(serviceName = "getUser",loadBlance = LoadBlance.IP_HASH)
    User getUser(Integer id, String name, String password);

    @RpcReference(serviceName = "updateUser", loadBlance = LoadBlance.RANDOM)
    int updateUser(User user);

    @RpcReference(serviceName = "async",loadBlance = LoadBlance.RANDOM)
    ResponseFuture<String> async();
}


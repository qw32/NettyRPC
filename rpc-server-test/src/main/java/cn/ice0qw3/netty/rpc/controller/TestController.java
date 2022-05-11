package cn.ice0qw3.netty.rpc.controller;

import cn.ice0qw3.netty.rpc.ref.client.ServiceInstance;
import cn.ice0qw3.netty.rpc.ref.server.BeanAndMethod;
import cn.ice0qw3.netty.rpc.ref.server.ServiceInfo;
import cn.ice0qw3.netty.rpc.registry.Registry;
import cn.ice0qw3.netty.rpc.transport.server.NettyServer;
import cn.ice0qw3.netty.rpc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private Registry registry;
    @Autowired
    private NettyServer nettyServer;

    @GetMapping("/startNetty")
    public String startNetty(){
        nettyServer.start();
        return "ok";
    }

    @GetMapping("/stopNetty")
    public String stopNetty(){
        nettyServer.stop();
        return "ok";
    }

}

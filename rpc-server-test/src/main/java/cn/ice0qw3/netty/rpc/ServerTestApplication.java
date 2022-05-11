package cn.ice0qw3.netty.rpc;

import cn.ice0qw3.netty.rpc.registry.Registry;
import cn.ice0qw3.netty.rpc.registry.RegistryConfig;
import cn.ice0qw3.netty.rpc.registry.zk.ZookeeperRegistry;
import cn.ice0qw3.netty.rpc.serializer.json.FastJsonSerializer;
import cn.ice0qw3.netty.rpc.serializer.kryo.KryoSerializer;
import cn.ice0qw3.netty.rpc.transport.NettyConfig;
import cn.ice0qw3.netty.rpc.transport.server.NettyServer;
import cn.ice0qw3.netty.rpc.utils.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ServerTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerTestApplication.class);
    }


    @Bean
    public Registry registry(){
        RegistryConfig config = RegistryConfig.builder()
                .connectionTimeout(500)
                .timeout(500)
                .ephemeral(true)
                .address("8.142.120.16:2181").build();
        Registry registry = new ZookeeperRegistry(config);
        return registry;
    }


    @Bean
    public NettyServer nettyServer(){
        NettyConfig config = NettyConfig.serverBuilder()
                .address(NetUtil.getLocalHost(), 8026)
//                .serializer(FastJsonSerializer.class)
                .heartBeatTimes(3)
                .heartBeatInterval(5)
                .serializer(KryoSerializer.class)
                .build();
        NettyServer nettyServer = new NettyServer(config);
        return nettyServer;
    }
}

package cn.ice0qw3.netty.rpc.service;

import ch.qos.logback.core.util.TimeUtil;
import cn.ice0qw3.netty.rpc.annotation.RpcService;
import cn.ice0qw3.netty.rpc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @RpcService(serviceName = "updateUser")
    public int updateUser(User user){
        System.out.println(user.toString());
        return 1;
    }
    @RpcService(serviceName = "getUser",weight = 5)
    public User getUser(Integer id, String name, String password){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        return user;
    }

    @RpcService(serviceName = "async")
    public String async(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello";
    }
}

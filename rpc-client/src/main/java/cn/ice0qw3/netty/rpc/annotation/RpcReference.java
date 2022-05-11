package cn.ice0qw3.netty.rpc.annotation;

import cn.ice0qw3.netty.rpc.loadbance.LoadBlance;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * 标明当前类是一个RPC客户端
 * @author ice0qw3
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD})
public @interface RpcReference {

    /**
     * 调用的服务名称
     * @return
     */
    String serviceName();

    /**
     * 使用的负载均衡策略
     * @return
     */
    LoadBlance loadBlance() default LoadBlance.RANDOM;

    int timeout() default 500;

}

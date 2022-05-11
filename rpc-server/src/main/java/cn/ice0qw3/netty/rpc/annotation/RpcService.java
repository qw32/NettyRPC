package cn.ice0qw3.netty.rpc.annotation;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RpcService {
    /**
     * 服务名称
     * @return
     */
    String serviceName();

    /**
     * 服务权重
     * @return
     */
    int weight() default 0;
}

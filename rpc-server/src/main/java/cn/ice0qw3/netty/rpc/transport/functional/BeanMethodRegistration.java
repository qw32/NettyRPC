package cn.ice0qw3.netty.rpc.transport.functional;

import java.lang.reflect.Method;

/**
 * 接口，表明能注册bean
 * @author ice0qw3
 */
public interface BeanMethodRegistration {
    int getPort();
    /**
     * 注册服务名，Bean,Method,方便反射调用
     * @param serviceName
     * @param bean
     * @param method
     */
    void registryServiceBean(String serviceName, Object bean, Method method);

    /**
     * 反注册服务
     * @param serviceName
     */
    void unRegistryServiceBean(String serviceName);

}

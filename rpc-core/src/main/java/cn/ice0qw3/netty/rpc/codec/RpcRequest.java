package cn.ice0qw3.netty.rpc.codec;

import cn.ice0qw3.netty.rpc.enums.MessageType;

import java.util.Arrays;

public final class RpcRequest implements RpcMessage {

    /**
     * 请求号
     */
    private String requestId;
    /**
     * 调用方法的名称
     */
    private String serviceName;

    /**
     * 调用方法的参数
     */
    private Object[] parameters;
    /**
     * 调用方法的参数类型
     */
    private Class<?>[] parameterTypes;

    @Override
    public MessageType getMessageType() {
        return MessageType.RPC_REQUEST;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "requestId='" + requestId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", parameters=" + Arrays.toString(parameters) +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                '}';
    }
}

package cn.ice0qw3.netty.rpc.transport;
/**
 * rpc服务器通用接口
 * @author ice0qw3
 */
public  interface  Server {
    void start() throws Exception;

    void stop() throws Exception;

}

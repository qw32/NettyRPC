package cn.ice0qw3.netty.rpc.transport.functional;

import cn.ice0qw3.netty.rpc.transport.client.Transporter;

/**
 *
 * @author ice0qw3
 */
public interface TransporterCreator {
    /**
     * 创建一个新的连接
     * @return
     */
    Transporter createTransporter(String host, int port);
}

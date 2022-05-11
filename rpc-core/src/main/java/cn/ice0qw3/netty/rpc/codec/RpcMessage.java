package cn.ice0qw3.netty.rpc.codec;


import cn.ice0qw3.netty.rpc.enums.MessageType;

import java.io.Serializable;


/**
 * 消息总接口，和MessageType双向绑定
 * @author ice0qw3
 */
public interface RpcMessage extends Serializable {
    /**
     * 获取消息类型枚举
     * @return
     */
    MessageType getMessageType();
}

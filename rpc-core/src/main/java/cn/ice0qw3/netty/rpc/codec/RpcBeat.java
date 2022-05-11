package cn.ice0qw3.netty.rpc.codec;

import cn.ice0qw3.netty.rpc.enums.MessageType;

public final class RpcBeat implements RpcMessage{
    private RpcBeat(){}
    private static final RpcBeat instance = new RpcBeat();
    public static RpcBeat instance(){return instance;}

    @Override
    public MessageType getMessageType() {
        return MessageType.RPC_BEAT;
    }
}

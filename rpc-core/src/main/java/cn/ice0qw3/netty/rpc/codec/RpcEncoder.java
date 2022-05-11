package cn.ice0qw3.netty.rpc.codec;

import cn.ice0qw3.netty.rpc.constant.RpcConstant;
import cn.ice0qw3.netty.rpc.serializer.RpcSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 编码器
 * 协议格式：magic（协议魔数），序列化器，消息类型，数据长度，数据
 * @author ice0qw3
 */
public class RpcEncoder extends MessageToByteEncoder<RpcMessage> {

    private final static Logger logger= LoggerFactory.getLogger(RpcEncoder.class);
    private final RpcSerializer serializer;

    public RpcEncoder(RpcSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, RpcMessage rpcMessage, ByteBuf byteBuf) throws Exception {
        //写文件魔数
        byteBuf.writeBytes(RpcConstant.MAGIC_NUMBER);
        //写序列化器
        byte serializerTypeCode = serializer.serializerTypeCode();
        byteBuf.writeByte(serializerTypeCode);
        //写消息类型
        byte messageTypeCode = rpcMessage.getMessageType().getTypeCode();
        byteBuf.writeByte(messageTypeCode);
        //编码数据
        byte[] data = serializer.encode(rpcMessage);
        //写数据长度
        byteBuf.writeInt(data.length);
        //写数据
        byteBuf.writeBytes(data);
    }

}

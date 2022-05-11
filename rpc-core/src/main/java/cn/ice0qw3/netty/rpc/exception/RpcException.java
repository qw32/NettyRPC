package cn.ice0qw3.netty.rpc.exception;

public class RpcException extends RuntimeException{
    public RpcException(String message){ super(message);}

    public RpcException(String message,Throwable cause){super(message,cause);}

    public RpcException(Throwable cause){super(cause);}

    public RpcException(String message, Throwable cause, boolean enableSuppression,boolean writeableStackTrace){
        super(message,cause,enableSuppression,writeableStackTrace);
    }
}

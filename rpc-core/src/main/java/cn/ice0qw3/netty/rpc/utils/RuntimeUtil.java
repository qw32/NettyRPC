package cn.ice0qw3.netty.rpc.utils;

public class RuntimeUtil {
    private RuntimeUtil(){}
    public static int availableProcessors(){
        return Runtime.getRuntime().availableProcessors();
    }
}

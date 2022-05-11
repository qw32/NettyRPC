package cn.ice0qw3.netty.rpc.utils;

public class NumberUtil {
    private NumberUtil() {
    }

    /**
     * int转字节数组
     *
     * @param target
     * @return b
     */
    public static byte[] intToByteArray(int target) {
        byte[] b = new byte[4];
        int count = 8;
        for (int i = 0; i < 4; ++i) {
            b[i] = (byte) (target >> (count * i) & 0xff);
        }
        return b;
    }


    /**
     * 字节数组转int
     *
     * @param array
     * @return ans
     */
    public static int byteArrayToInt(byte[] array) {
        int ans = 0;
        int count = 8;
        for (int i = 0; i < 4; ++i) {
            ans = (array[i]  & 0xff) << (count * i);
        }
        return ans;
    }
}

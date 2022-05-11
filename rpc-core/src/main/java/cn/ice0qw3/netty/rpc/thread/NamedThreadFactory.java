package cn.ice0qw3.netty.rpc.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {
    private static final String DEFAULT_PREFIX = "thread_";
    /** 命名前缀 */
    private final String prefix;
    /** 线程组 */
    private final ThreadGroup group;
    /** 线程数 */
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    /** 是否守护线程 */
    private final boolean isDaemon;
    /** 无法捕获的异常统一处理 */
    private final Thread.UncaughtExceptionHandler handler;


    /**
     * 构造
     * @param prefix 线程名前缀
     * @return isDaemon 是否守护线程
     */
    public NamedThreadFactory(String prefix , boolean isDaemon){
        this(prefix,null,isDaemon);
    }
    /**
     * 构造
     *
     * @param prefix 线程名前缀
     * @param threadGroup 线程组，可以为null
     * @param isDaemon 是否守护线程
     */
    public NamedThreadFactory(String prefix, ThreadGroup threadGroup, boolean isDaemon) {
        this(prefix, threadGroup, isDaemon, null);
    }
    /**
     * 构造
     *
     * @param prefix 线程名前缀
     * @param threadGroup 线程组，可以为null
     * @param isDaemon 是否守护线程
     * @param handler 未捕获异常处理
     */
    public NamedThreadFactory(String prefix, ThreadGroup threadGroup, boolean isDaemon, Thread.UncaughtExceptionHandler handler) {
        if(prefix == null || "".equals(prefix)){
            this.prefix = DEFAULT_PREFIX;
        } else {
            this.prefix = prefix;
        }
        if (null == threadGroup) {
            SecurityManager s = System.getSecurityManager();
            if(s != null){
                threadGroup =  s.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
        }
        this.group = threadGroup;
        this.isDaemon = isDaemon;
        this.handler = handler;
    }




    @Override
    public Thread newThread(Runnable r) {
        final Thread t = new Thread(this.group,r,String.format("%s%s",prefix,threadNumber.getAndIncrement()));

        //守护线程
        if (!t.isDaemon()){
            if (isDaemon){
                //原线程为非守护则设置为守护
                t.setDaemon(true);
            }
        }else if (!isDaemon){
            //原线程为守护则还原为非守护
            t.setDaemon(false);
        }
        //异处处理
        if (this.handler != null){
            t.setUncaughtExceptionHandler(handler);
        }
        //优先级
        if (Thread.NORM_PRIORITY != t.getPriority()){
            //标准优先级
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
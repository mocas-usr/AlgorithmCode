package code.多线程;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/3 下午8:31
 * @email: wangyuhang_mocas@163.com
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-08-03 20:31
 */
public class 自定义线程池 {
    static class ThreadPools {
        private volatile static ThreadPools threadPool = null;
        //核心线程数，实际运行的线程数
        public static final int corePoolSize = 1;
        //最大线程数
        public static final int maximumPoolSize = 2;
        //存活时间
        public static final long keepAliveTime = 60L;
        public static final TimeUnit unit = TimeUnit.SECONDS;
        //缓存队列
        public static final ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue(3);
        //线程池
        public static ThreadPoolExecutor threadPoolExecutor = null;
        private ThreadPools(){
            threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,unit,arrayBlockingQueue);
        }
        public static void executor(int num,Runnable runnable){
            if(num <= 0){
                return;
            }
            if(threadPool == null){
                synchronized (ThreadPools.class){
                    if(threadPool == null){
                        threadPool = new ThreadPools();
                    }
                }
            }
            for(int i = 0;i < num;i++){
                threadPoolExecutor.execute(runnable);
            }
            threadPoolExecutor.shutdown();
        }
    }

    static class Run implements Runnable{
        @Override
        public void run() {
            //具体操作
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        ThreadPools.executor(5,new Run());
    }
}

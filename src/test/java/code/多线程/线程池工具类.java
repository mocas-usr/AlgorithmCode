package code.多线程;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/3 下午8:33
 * @email: wangyuhang_mocas@163.com
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-08-03 20:33
 */
public class 线程池工具类 {
    public static class ThreadPoolDemo {
        //线程中默认线程的个数
        private static int threadCount = 5;
        //队列中默认任务的个数
        private static int queueCount = 100;
        //工作线程组
        private WorkThread[] workThreads;
        //任务队列，作为一个缓冲，
        //这里注意：taskQueue既是任务队列，也是线程工作池的队列，都从此队列取任务执行。
        private BlockingQueue<Runnable> taskQueue;
        //用户在构建线程池的时候，希望启动的线程数
        private int work_num;

        /**
         * @param work_num  线程池中工作线程的个数
         * @param taskCount
         */
        public ThreadPoolDemo(int work_num, int taskCount) {
            if (work_num <= 0) work_num = threadCount;
            if (taskCount <= 0) taskCount = queueCount;
            this.work_num = work_num;
            taskQueue = new ArrayBlockingQueue<>(taskCount);
            workThreads = new WorkThread[work_num];
            for (int i = 0; i <work_num ; i++) {
                workThreads[i]=new WorkThread();
                workThreads[i].start();
            }

            //Runtime.getRuntime().availableProcessors();
        }

        /**
         * 执行任务，其实只是把任务加入任务队列，什么时候执行有线程池管理器决定
         * @param task
         */
        public void execute(Runnable task){
            try {
                taskQueue.put(task);
                System.out.println("....线程队列大小................>>>>>>"+taskQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * 销毁线程池，该方法保证在所有任务都完成的情况下才销毁所有线程，否则等待任务完成才销毁
         */
        public void destory(){
            System.out.println(".....ready close pool");
            for (int i = 0; i < work_num; i++) {
                WorkThread t = workThreads[i];
                if(t.isAlive()){
                    t.stopWork();
                }
                workThreads[i]=null;
            }
            taskQueue.clear();//清空任务队列
            System.out.println("线程池销毁/");
        }
        // 覆盖toString方法，返回线程池信息：工作线程个数和已完成任务个数
        @Override
        public String toString() {
            return "WorkThread number:" + work_num
                    + "  wait task number:" + taskQueue.size();
        }
        public int getQueueCount(){
            return taskQueue.size();
        }

        private class WorkThread extends Thread {
            @Override
            public void run() {
                Runnable r = null;
                while (!interrupted()) {
                    try {
                        if(taskQueue.size()>0){
                            r = taskQueue.take();
                            if (r != null) {
                                System.out.println("线程......" + r + "......ready exec ........");
                                r.run();
                            }
                            r = null;//heap gc
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            public void stopWork(){
                interrupt();
            }
        }

    }
}

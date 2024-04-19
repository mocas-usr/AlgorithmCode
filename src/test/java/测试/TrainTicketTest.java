package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/17 22:20
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Date;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-17 22:20
 */
public class TrainTicketTest {
    // 全局变量，必须保证所有线程都在使用同一个锁
    Object object = new Object();
    int num = 2;

    public static void main(String[] args) {
        // 抢火车票功能

        TrainTicketTest synchronizedTest = new TrainTicketTest();
        for (int i = 0; i < 5; i ++) {
            new Thread(synchronizedTest.new TrainTicketThread()).start();
        }
    }

    //锁this
    class MyRunnableSet implements Runnable {
//        public int num = 1;
//        //    test one;
////    public MyRunnableSet(test testOne)
////    {
////        this.one=testOne;
////    }
//        int[] nums = new int[]{1, 2};
//
//        public int getNum() {
//            return num;
//        }

        @Override
        public void run() {
            System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t" + this);
            synchronized (this) {
                try {
                    System.out.println(" thread");
                    Thread.sleep(10000);
                    System.out.println("test");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class TrainTicketThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "running");
            try { Thread.sleep(500);} catch (InterruptedException e) { }
            synchronized (object) {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "\t抢到一张票\t目前还有" + num + "张\t");
                    int temp = num - 1;
                    num = temp;
                    System.out.println(Thread.currentThread().getName() + "还剩余" + num + "张");
                }
            }
        }
    }
}
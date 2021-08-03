package code.多线程;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/3 下午9:45
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-08-03 21:45
 */
//https://www.nowcoder.com/discuss/654079?source_id=profile_create_nctrack&channel=-1
public class 多线程打印 {
    //交替打印abc
    static class Wait_Notify_ACB {

        private int num;
        private final Object LOCK = new Object();

        private void printABC(int targetNum) {
            for (int i = 0; i <10; i++) {
                synchronized (LOCK) {
                    while (num % 3 != targetNum) { //想想这里为什么不能用if代替，想不起来可以看公众号上一篇文章
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num++;
                    System.out.print(Thread.currentThread().getName());
                    LOCK.notifyAll();
                }
            }
        }

        public static void main(String[] args) {
            Wait_Notify_ACB  wait_notify_acb = new Wait_Notify_ACB ();
            new Thread(() -> {
                wait_notify_acb.printABC(0);
            }, "A").start();
            new Thread(() -> {
                wait_notify_acb.printABC(1);
            }, "B").start();
            new Thread(() -> {
                wait_notify_acb.printABC(2);
            }, "C").start();
        }
    }



    static class  Wait_Notify_Odd_Even{

        private Object monitor = new Object();
        private volatile int count;

        Wait_Notify_Odd_Even(int initCount) {
            this.count = initCount;
        }

        private void printOddEven() {
            synchronized (monitor) {
                while (count < 10) {
                    try {
                        System.out.print( Thread.currentThread().getName() + "：");
                        System.out.println(++count);
                        monitor.notifyAll();
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //防止count=10后，while()循环不再执行，有子线程被阻塞未被唤醒，导致主线程不能退出
                monitor.notifyAll();
            }
        }

        public static void main(String[] args) throws InterruptedException {

            Wait_Notify_Odd_Even waitNotifyOddEven = new Wait_Notify_Odd_Even(0);
            new Thread(waitNotifyOddEven::printOddEven, "odd").start();
            Thread.sleep(10); //为了保证线程odd先拿到锁
            new Thread(waitNotifyOddEven::printOddEven, "even").start();
        }
    }
}

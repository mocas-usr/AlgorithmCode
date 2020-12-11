package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/1 下午8:37
 * @email: wangyuhang_mocas@163.com
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-01 20:37
 */
public class 按序打印4 {
    class Foo {
        //信号量
        CountDownLatch CountDownLatch12;
        CountDownLatch CountDownLatch23;

        public Foo() {
            //相当于全局可见变量
            CountDownLatch12=new CountDownLatch(1);
            CountDownLatch23=new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            CountDownLatch12.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            //等待计数器归零再向下执行
            CountDownLatch12.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            CountDownLatch23.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            CountDownLatch23.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}

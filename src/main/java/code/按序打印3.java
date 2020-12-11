package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/1 下午8:32
 * @email: wangyuhang_mocas@163.com
 */

import java.util.concurrent.Semaphore;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-01 20:32
 */
public class 按序打印3 {
    class Foo {
        //信号量
        Semaphore semaphore12;
        Semaphore semaphore23;

        public Foo() {
            //相当于全局可见变量
            semaphore12=new Semaphore(0);
            semaphore23=new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semaphore12.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphore12.acquire();//如果能获取不到。，则阻塞
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            semaphore23.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphore23.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}

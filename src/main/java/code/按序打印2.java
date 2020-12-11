package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/1 下午7:35
 * @email: wangyuhang_mocas@163.com
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-01 19:35
 */
public class 按序打印2 {
    class Foo {

        //记录线程执行情况

        int num=1;
        Lock lock=new ReentrantLock();//锁
        //锁的几个条件
        Condition condition1=lock.newCondition();
        Condition condition2=lock.newCondition();
        Condition condition3=lock.newCondition();

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            //加锁
            lock.lock();
            try {
                while (num!=1)
                {
                    //具体的锁条件
                    condition1.await();
                }
                // printFirst.run() outputs "first". Do not change or remove this line.
                num=2;
                printFirst.run();
                condition2.signal();
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }

        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                while (num!=2)
                {
                    //具体的锁条件
                    condition2.await();
                }
                // printFirst.run() outputs "first". Do not change or remove this line.
                num=3;
                printSecond.run();
                condition3.signal();
            }catch (Exception e)
            {}
            finally {
                lock.unlock();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.

        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {


                while (num!=3)
                {
                    condition3.await();
                }
                // printFirst.run() outputs "first". Do not change or remove this line.
                num=1;
                printThird.run();
                condition1.signal();
                condition2.signal();
            }catch (Exception e)
            {
            }
            finally {
                lock.unlock();
            }
            // printThird.run() outputs "third". Do not change or remove this line.

        }
    }
}

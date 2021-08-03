package code.多线程;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/29 下午8:19
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-29 20:19
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//https://www.nowcoder.com/discuss/654079?source_id=profile_create_nctrack&channel=-1
public class 按序打印 {

    class Foo1 {

        private volatile int index = 0;
        private Object lock = new Object();

        public Foo1() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            synchronized (lock)
            {
                while (index!=0)
                {
                    lock.wait();
                }
                printFirst.run();
                index=1;
                lock.notifyAll();
            }

        }

        public void second(Runnable printSecond) throws InterruptedException {

            synchronized (lock)
            {
                while (index!=1)
                {
                    lock.wait();
                }
                printSecond.run();
                index=2;
                lock.notifyAll();

            }
            // printSecond.run() outputs "second". Do not change or remove this line.
        }

        public void third(Runnable printThird) throws InterruptedException {

            synchronized (lock)
            {
                while (index!=2)
                {
                    lock.wait();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                lock.notifyAll();
            }

        }
    }
    //lock锁


    class Foo {

        int num;
        Lock lock;
        //精确的通知和唤醒线程
        Condition condition1, condition2, condition3;

        public Foo() {
            num = 1;
            lock = new ReentrantLock();
            condition1 = lock.newCondition();
            condition2 = lock.newCondition();
            condition3 = lock.newCondition();
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try {
                while (num != 1) {
                    condition1.await();
                }
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                num = 2;
                condition2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                while (num != 2) {
                    condition2.await();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                num = 3;
                condition3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                while (num != 3) {
                    condition3.await();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                num = 1;
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}

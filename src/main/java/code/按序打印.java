package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/29 下午8:06
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-29 20:06
 */
public class 按序打印 {
    class Foo {

        //执行情况
        public boolean firstFinished=false;
        public boolean secondFinished=false;
        //用于锁的实例
        private Object  object=new Object();
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            synchronized (object)
            {
                //完成功能
                printFirst.run();
                //准备释放锁
                firstFinished=true;
                object.notifyAll();

            }
            // printFirst.run() outputs "first". Do not change or remove this line.

        }

        public void second(Runnable printSecond) throws InterruptedException {

            synchronized (object)
            {
                while (firstFinished!=true)
                {
                    object.wait();
                }
                printSecond.run();
                secondFinished=true;
                object.notifyAll();

            }
            // printSecond.run() outputs "second". Do not change or remove this line.

        }

        public void third(Runnable printThird) throws InterruptedException {

            synchronized (object)
            {
                while (secondFinished!=true)
                {
                    object.wait();
                }
                printThird.run();
            }

            // printThird.run() outputs "third". Do not change or remove this line.

        }
    }
}

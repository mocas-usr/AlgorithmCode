package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/17 21:44
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Date;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-17 21:44
 */
public class 锁测试 {
    public static test testOne=new test();

    public static void main(String[] args) throws InterruptedException {


        锁测试 index = new 锁测试();

//        System.out.println("runnable=" + runnable);
        //set方法开启
        new Thread(index.new MyRunnableSet()).start();
//        new Thread(index.MyRunnableSet, "Thread-A").start();
        Thread.sleep(5000);
       System.out.println(testOne.getVal());

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
            synchronized (testOne) {
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


}


class  test
{
    public int val=2;
    public int getVal()
    {
        return val;
    }
}


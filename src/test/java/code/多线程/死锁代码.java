package code.多线程;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/19 上午11:39
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-19 11:39
 */
public class 死锁代码 {
    //死锁对象
    public static Object o1 = new Object();
    public static Object o2 = new Object();

    public static void main(String[] args) {


        Thread a=new Thread(()->{

            try {
                while (true)
                {
                    synchronized (o1){
                        System.out.println(Thread.currentThread().getName()+"锁住o1");
                        Thread.sleep(1000);
                        synchronized (o2)
                        {
                            System.out.println(Thread.currentThread().getName()+"锁住o2");
                        }
                    }
                }

            }catch (Exception e)
            {
                e.printStackTrace();
            }

        });


        Thread b=new Thread(()->{

            try {
                while (true)
                {
                    synchronized (o2){
                        System.out.println(Thread.currentThread().getName()+"锁住o2");
                        Thread.sleep(1000);
                        synchronized (o1)
                        {
                            System.out.println(Thread.currentThread().getName()+"锁住o1");
                        }
                    }
                }

            }catch (Exception e)
            {
                e.printStackTrace();
            }

        });

        a.start();
        b.start();
    }




}

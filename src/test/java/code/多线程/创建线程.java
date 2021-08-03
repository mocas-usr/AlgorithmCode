package code.多线程;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/19 下午3:41
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-19 15:41
 */
public class 创建线程 {

    public static void main(String[] args) throws InterruptedException {

        //thread方式
        myThread t1 = new myThread();
        t1.start();
        Thread.sleep(5000);
        //runnable方式
        Runnable r1 = new myRunnable();
        new Thread(r1).start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("匿名Thread");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("匿名runnable");

            }
        }).start();

        //lamda表达式
        new Thread(() -> {
            System.out.println("lamdaThread");
        }).start();

        Runnable runnable = () -> {
            System.out.println("lamda表达式创建线程");
        };
        new Thread(runnable).start();;
    }


}

class myThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Thread方式");
    }
}

class myRunnable implements Runnable {


    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "runnable方式");
    }
}

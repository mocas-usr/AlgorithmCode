package code.多线程;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/13 下午3:21
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-13 15:21
 */
public class 生产者消费者 {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Thread p1 = new Thread(new Producer(storage));
        Thread p2 = new Thread(new Producer(storage));
        Thread p3 = new Thread(new Producer(storage));

        Thread c1 = new Thread(new Consumer(storage));
        Thread c2 = new Thread(new Consumer(storage));
        Thread c3 = new Thread(new Consumer(storage));

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }


    public static class Storage {

        // 仓库容量
        private final int MAX_SIZE = 10;
        // 仓库存储的载体
        private LinkedList<Object> list = new LinkedList<>();

        public void produce() {
            synchronized (list) {
                while (list.size() + 1 > MAX_SIZE) {
                    System.out.println("【生产者" + Thread.currentThread().getName()
                            + "】仓库已满");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(new Object());
                System.out.println("【生产者" + Thread.currentThread().getName()
                        + "】生产一个产品，现库存" + list.size());
                list.notifyAll();
            }
        }

        public void consume() {
            synchronized (list) {
                while (list.size() == 0) {
                    System.out.println("【消费者" + Thread.currentThread().getName()
                            + "】仓库为空");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.remove();
                System.out.println("【消费者" + Thread.currentThread().getName()
                        + "】消费一个产品，现库存" + list.size());
                list.notifyAll();
            }
        }
    }
    //生产者
    public static class Producer implements Runnable{
        private Storage storage;

        public Producer(){}

        public Producer(Storage storage){
            this.storage = storage;
        }

        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(1000);
                    storage.produce();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //消费者
    public static class Consumer implements Runnable{
        private Storage storage;

        public Consumer(){}

        public Consumer(Storage storage){
            this.storage = storage;
        }

        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(3000);
                    storage.consume();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

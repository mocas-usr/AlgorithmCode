package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/29 下午7:40
 * @email: wangyuhang_mocas@163.com
 */



import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-29 19:40
 */
public class 生产者消费者 {

    //wait() / notify()方法

    public static void main(String[] args) {
        //唯一的仓库
        Storage storage=new Storage();
        //生产者消费者
        Thread producer=new Thread(new producer(storage));
        Thread consumer=new Thread(new consumer(storage));

        producer.start();
        for (int i=0;i<15;i++)
        {
            new Thread(new producer(storage)).start();
        }

        consumer.start();
    }

}

//生产者
class producer implements Runnable
{
    //对象装进去
    private Storage storage;
    public producer() {
    }
    public producer(Storage storage) {
        this.storage=storage;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            storage.produce();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//消费者
class consumer implements Runnable
{
    //对象装进去
    private Storage storage;
    public consumer() {
    }
    public consumer(Storage storage) {
        this.storage=storage;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            storage.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//仓库
class Storage {

    //存储
    private List<Object> list=new LinkedList<>();
    //方法锁住
    public   void produce() throws InterruptedException {
        synchronized (list)
        {
            //如果超额，则阻塞
            while (list.size()>=10)
            {
                System.out.println("仓库已经满了");
                list.wait();
            }
            list.add(new Object());
            System.out.println(Thread.currentThread().getName()+"生产一个，共有"+list.size());
            list.notifyAll();//开启运行

        }

    }

    //消费者
    public void consume() throws InterruptedException {
        //锁住list
        synchronized(list)
        {
            //消费最上面的
            while (list.size()==0)
            {
                System.out.println("仓库空了");
                //如果没有了，则一样阻塞
                list.wait();
            }
            list.remove(list.size()-1);
            System.out.println(Thread.currentThread().getName()+"消费一个，共有"+list.size());
            list.notifyAll();
        }

    }


}

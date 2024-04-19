package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/5 12:37
 * @email: wangyuhang_mocas@163.com
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-08-05 12:37
 */
public class 线程池 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                System.out.println("thread id is: " + Thread.currentThread().getId());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

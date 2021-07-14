package code.堆;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/15 下午7:55
 * @email: wangyuhang_mocas@163.com
 */

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-15 19:55
 */
public class 最小的k个数 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {

            return new int[0];
        }
        Queue<Integer> queue = new PriorityQueue<>();
        int[] res = new int[k];

        for (int num : arr) {
            queue.add(num);
        }

        for (int i=0;i<k;i++)
        {
            res[i]=queue.poll();
        }
        return res;


    }
}

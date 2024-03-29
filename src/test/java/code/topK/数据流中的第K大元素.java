package code.topK;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/25 上午10:53
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-25 10:53
 */
public class 数据流中的第K大元素 {

    class KthLargest {

        Queue<Integer> queue;
        int size;
        public KthLargest(int k, int[] nums) {
            size=k;
            queue=new PriorityQueue<>();
            for (int num:nums)
            {
                add(num);
            }
        }

        public int add(int val) {

            if (queue.size()<size)
            {
                queue.add(val);
            }else
            {
                if (val>queue.peek())
                {
                    queue.poll();
                    queue.add(val);
                }
            }
            return queue.peek();
        }
    }

    @Test
    public void test() {
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        int num1=   kthLargest.add(3);   // return 4
        num1=kthLargest.add(5);   // return 5
        num1=kthLargest.add(10);  // return 5
       num1= kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8


    }
}

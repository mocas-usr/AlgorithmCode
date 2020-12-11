package code.topK;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/25 上午10:53
 * @email: wangyuhang_mocas@163.com
 */

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-25 10:53
 */
public class 数据流中的第K大元素 {
    class KthLargest {

        //有序队列
        Queue<Integer> queue;
        int fix_k;
        public KthLargest(int k, int[] nums) {
            fix_k=k;
            queue=new PriorityQueue<>(k);//k个有序队列，队伍首部最小

            for (int i=0;i<nums.length;i++) {
                add(nums[i]);
            }

        }

        public int add(int val) {
            //队列中已经有的元素个数
            int len=queue.size();
            if (len<fix_k)
            {
                queue.offer(val);
            }else
            {
                if (val>queue.peek())
                {
                    queue.poll();
                    queue.offer(val);
                }
            }

            return queue.peek();

        }
    }

}

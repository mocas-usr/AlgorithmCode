package code.堆;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/15 下午7:55
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-15 19:55
 */
public class 数据流中的第K大元素 {
    class KthLargest {

        //小顶堆
        Queue<Integer> list;
        int size;
        public KthLargest(int k, int[] nums) {
            size=k;
            list=new PriorityQueue<>();
            for (int num:nums)
            {
                add(num);
            }
        }

        public int add(int val) {
            if (list.size()<size)
            {
                list.add(val);
            }else
            {
                if (val>list.peek())
                {
                    list.add(val);
                    list.poll();
                }

            }
            return list.peek();
        }
    }
}

package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/9 上午10:53
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-09 10:53
 */
public class 滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] result=new int[nums.length-k+1];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() &&nums[deque.peekLast()]<=nums[i])
            {
                deque.pollLast();
            }
            deque.offer(i);
            //保持队列长度
            if (i-k>=deque.peek())
            {
                deque.poll();
            }

            if (i-k>=-1)
            {
                result[i-k+1]=nums[deque.peek()];
            }

        }
        return result;

    }

    @Test
    public void test()
    {
       int[] nums ={1,3,-1,-3,5,3,6,7};
       int k = 3;
        int[] res=maxSlidingWindow(nums, k);
        System.out.println(res);
    }
}

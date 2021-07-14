package code.单调栈;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/9 上午11:23
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-09 11:23
 */
public class 滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        Integer in1=1;
        Integer in2=new Integer(1);
        Integer in3=2-1;
        Integer in4=200;
        Integer in5=200;
        int in6=200;
        System.out.println(in1==in2);
        System.out.println(in1==in3);
        System.out.println(in4==in5);
        System.out.println(in4==in6);

        Deque<Integer> queue = new LinkedList<>();

        int[] res = new int[nums.length - k+ 1];
        //初始化窗口
        //保持队列头部最大
        for (int i = 0; i < k; i++) {

            while (!queue.isEmpty() && nums[i]>=nums[queue.peekLast()])
            {
                queue.pollLast();
            }
            queue.add(i);
        }
        int t=0;
        res[t++]=nums[queue.peekFirst()];

        for (int i=k;i<nums.length;i++)
        {
            //保持最大队列
            while (!queue.isEmpty() && nums[i]>=nums[queue.peekLast()])
            {
                queue.pollLast();
            }
            queue.add(i);
            //滑动窗口长度超过k
            if (i-queue.peek()>=k)
            {

                queue.pollFirst();
            }
            res[t++]=nums[queue.peekFirst()];
        }
        return res;
    }

    @Test
    public void test()
    {
        int[] nums ={7,2,4} ;
        int k = 2;
        int[] res=maxSlidingWindow(nums,k);
        System.out.println(res);
    }
}

package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/12 上午10:47
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-12 10:47
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        //考虑长度为0情况
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        //长度不为0情况
        //初始化队列
        Deque<Integer> deque = new LinkedList<Integer>();
        //结果集
        int[] res = new int[nums.length - k + 1];
        int index=0;

        //双向队列,队列尾j，队列头i
        //如果没出现窗口时
        for (int h=0;h<k;h++)
        {
            //循环，使队列头最大，递减
            while (!deque.isEmpty() && deque.peekFirst()<nums[h])
            {
                deque.removeLast();

            }
            //比新入列小的都删除，将此数值加入队尾
            deque.addLast(nums[h]);
        }

        //出现窗口初始化
        res[index++]=deque.peekFirst();
        //出现窗口
        for (int i=k; i < nums.length; i++)
        {
            //队列长度是k，超出长度移除
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            //保持队列递减，
            while(!deque.isEmpty() && deque.peekLast()<nums[i])
            {
                deque.removeLast();
            }
            deque.addLast(nums[i]);

            res[index++]=deque.peekFirst();

        }
        return res;
    }




    @Test
    public void  Solution(){

        Solution solution=new Solution();
        //定义初始化变量
        int[] nums={1,-1};
        int k=1;
        //准备输出调试
        int[] result=solution.maxSlidingWindow(nums,k);

        System.out.println(Arrays.toString(result));
    }
}



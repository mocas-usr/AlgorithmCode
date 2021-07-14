package code.滑动窗口;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/29 下午9:01
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-29 21:01
 */
public class 滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {


        Deque<Integer> deque = new LinkedList<>();

        //初始化窗口
        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(i);

        }
        int[] res = new int[nums.length - k + 1];
        int t = 0;
        res[t++] = nums[deque.peekFirst()];
        //滑动窗口
        for (int i = k; i < nums.length; i++) {

            //扩增窗口
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(i);
            //缩减窗口
            if (i-deque.peekFirst()>= k) {
                deque.pollFirst();
            }
            //当前操作
            res[t++] = nums[deque.peekFirst()];
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {7,2,4};
        int k = 2;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(res);
    }
}

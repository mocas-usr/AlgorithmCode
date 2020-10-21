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
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-12 10:47
 */
/*给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

        示例:
        输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
        输出: [3,3,5,5,6,7]
        解释:

        滑动窗口的位置                最大值
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7*/


public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        //考虑长度为0情况
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        //长度不为0情况
        //初始化队列
        Deque<Integer> deque = new LinkedList<>();
        //结果集
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        //双向队列,队列尾j，队列头i
        //如果没出现窗口时
        for (int h = 0; h < k; h++) {
            //循环，使队列头最大，递减
            while (!deque.isEmpty() && deque.peekLast() < nums[h]) {
                deque.removeLast();

            }
            //比新入列小的都删除，将此数值加入队尾
            deque.addLast(nums[h]);
        }

        //出现窗口初始化
        res[index++] = deque.peekFirst();
        //出现窗口
        for (int i = k; i < nums.length; i++) {
            //队列长度是k，超出长度移除
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            //保持队列递减，
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);

            res[index++] = deque.peekFirst();

        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        //单调队列
        //下面是要注意的点：
        //队列按从大到小放入
        //如果首位值（即最大值）不在窗口区间，删除首位
        //如果新增的值小于队列尾部值，加到队列尾部
        //如果新增值大于队列尾部值，删除队列中比新增值小的值，如果在把新增值加入到队列中
        //如果新增值大于队列中所有值，删除所有，然后把新增值放到队列首位，保证队列一直是从大到小
        if (nums.length == 0)
            return nums;

        Deque<Integer> deque = new LinkedList<>();
        int[] arr = new int[nums.length - k + 1];
        int index = 0;  //arr数组的下标
        //未形成窗口区间
        for (int i = 0; i < k; i++) {
            //队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
            //一直循环删除到队列中的值都大于当前值，或者删到队列为空
            while (!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.removeLast();
            //执行完上面的循环后，队列中要么为空，要么值都比当前值大，然后就把当前值添加到队列中
            deque.addLast(nums[i]);
        }
        //窗口区间刚形成后，把队列首位值添加到队列中
        //因为窗口形成后，就需要把队列首位添加到数组中，而下面的循环是直接跳过这一步的，所以需要我们直接添加
        arr[index++] = deque.peekFirst();
        //窗口区间形成
        for (int i = k; i < nums.length; i++) {
            //i-k是已经在区间外了，如果首位等于nums[i-k]，那么说明此时首位值已经不再区间内了，需要删除
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            //删除队列中比当前值大的值
            while (!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.removeLast();
            //把当前值添加到队列中
            deque.addLast(nums[i]);
            //把队列的首位值添加到arr数组中
            arr[index++] = deque.peekFirst();
        }
        return arr;
    }


    @Test
    public void Solution() {

        Solution solution = new Solution();
        //定义初始化变量
        int[] nums = {1, -1};
        int k = 1;
        //准备输出调试
        int[] result = solution.maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));
    }
}



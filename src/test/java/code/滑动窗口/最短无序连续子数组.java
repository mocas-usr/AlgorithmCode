package code.滑动窗口;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/17 20:42
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-01-17 20:42
 */
public class 最短无序连续子数组 {
    //两次遍历
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <=1) {
            return 0;
        }
        int left = nums.length - 1;
        int right = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                min=nums[i];
            }else
            {
                left=i;
            }
        }

        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]>=max)
            {
                max=nums[i];
            }else
            {
                right=i;
            }
        }
        if (left>right)
        {
            return 0;
        }else
        {
            return right-left+1;
        }

    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 3, 3};
        int res = findUnsortedSubarray(nums);
        System.out.println(res);
    }
}

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

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int left = nums.length - 1;
        int right = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                left = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                right = i;
            }
        }
        if (left < right) {
            return right - left + 1;
        } else {
            return 0;
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,3,3};
        int res = findUnsortedSubarray(nums);
        System.out.println(res);
    }
}

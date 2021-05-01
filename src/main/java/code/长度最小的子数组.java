package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/13 下午5:05
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-13 17:05
 */
public class 长度最小的子数组 {

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int res = nums.length + 1;
        int sum = nums[right];

        while (right < nums.length && left < nums.length) {
            if (sum < target) {
                right++;
                if (right < nums.length) {
                    sum = sum + nums[right];
                }

            } else {
                res = Math.min(res, right - left + 1);
                sum = sum - nums[left];
                left++;

            }
        }
        if (res < nums.length + 1) {
            return res;
        } else {
            return 0;
        }


    }

    public int minSubArrayLen2(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= s) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    @Test
    public void test() {
        int target = 6;
        int[] nums = {10,2,3};
        int res = minSubArrayLen(target, nums);
        System.out.println(res);
    }
}

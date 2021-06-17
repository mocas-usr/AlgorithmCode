package code.数字问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/15 21:43
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-01-15 21:43
 */
public class 乘积最大子数组 {

    public int maxProduct(int[] nums) {

        if (nums.length < 1) {
            return -1;
        }
        int maxF = nums[0];
        int minF = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = maxF;
            int min = minF;

            maxF = Math.max(nums[i], Math.max(nums[i] * min, nums[i] * max));
            minF = Math.min(nums[i], Math.min(nums[i] * max, nums[i] * min));
            ans = Math.max(maxF, ans);
        }
        return ans;

    }

    @Test
    public void test() {
        int[] nums = {-4, -3, -2};
        int res = maxProduct(nums);
        System.out.println(res);
    }

}

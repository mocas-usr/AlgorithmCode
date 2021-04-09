package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/16 13:27
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-01-16 13:27
 */
public class 乘积最大子数组 {

    //动态规划
    public int maxProduct(int[] nums) {


        int max = nums[0];
        int min = nums[0];
        int res = max;
        for (int i = 1; i < nums.length; i++) {
            int maxF=max;
            int minF=min;
            max = Math.max(Math.max(maxF * nums[i], minF * nums[i]), nums[i]);
            min = Math.min(nums[i], Math.min(nums[i] * maxF, nums[i] * minF));

            res = Math.max(max, res);

        }
        return res;


    }

    @Test
    public void test() {
        int[] nums={-4,-3,-2};
        int res=maxProduct(nums);
        System.out.println(res);
    }
}

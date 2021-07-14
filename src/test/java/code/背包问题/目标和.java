package code.背包问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/9 下午8:14
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-09 20:14
 */
public class 目标和 {

    //回溯
    char[] count;
    int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        count = new char[nums.length];

        dfs(nums, target, 0, 0);
        return res;
    }

    public void dfs(int[] nums, int target, int index, int sum) {
        //终止条件
        if (index == nums.length) {
            //
            if (sum == target) {
                res++;
            }
            return;
        }

        //剪枝
        //当前选择
        count[index] = '+';
        sum += nums[index];
        //下一路径
        dfs(nums, target, index + 1, sum);
        //恢复现场
        sum -= nums[index];

        count[index] = '-';
        sum -= nums[index];
        //下一路径
        dfs(nums, target, index + 1, sum);
        //恢复现场
        sum += nums[index];

    }

    public int findTargetSumWays2(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int n = nums.length;
        //选取前i个数，和为neg的数的方案
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {

                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - num] + dp[i - 1][j];
                }
            }
        }


        return dp[n][neg];


    }

    public int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int n = nums.length;
        //转换为硬币问题，用num构成数值target
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = neg; i >=num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[neg];
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 1};
        int target = 0;

        int res = findTargetSumWays3(nums, target);
        System.out.println(res);
    }
}

package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/9 下午4:40
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-09 16:40
 */
public class 分割等和子集 {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        if (nums.length<2)
        {
            return false;
        }
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        int len = nums.length;

        //dp[i][j]代表[0,i]数组中装入j容量物品
        boolean[][] dp = new boolean[len][target + 1];

        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        if (nums[0] < target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++)
        {
            //容量
            int num=nums[i];
            for (int j=1;j<=target;j++)
            {
                //如果容量小于j
                if (j>=num)
                {
                    dp[i][j]=dp[i-1][j]| dp[i-1][j-num];
                }else
                {
                    //如果容量大于j
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[len-1][target];


    }


    public boolean dfs(int[] nums, int target, int index) {
        if (nums.length == index) {
            return false;
        }

        //剪枝
        if (target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }

        for (int i = index; i < nums.length; i++) {
            //当前选择
            //下一路径
            if (dfs(nums, target - nums[i], i + 1)) {
                return true;
            }
            //恢复现场

        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = {1, 5, 11, 5};
        boolean res = canPartition(nums);
        System.out.println(res);
    }
}

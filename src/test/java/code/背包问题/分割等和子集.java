package code.背包问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/9 下午8:14
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-09 20:14
 */
public class 分割等和子集 {


    public boolean canPartition(int[] nums) {

        int sum=0;

        for (int num:nums)
        {
            sum+=num;
        }
        if (sum%2!=0)
        {
            return false;
        }

        int target=sum/2;

        //背包
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        //背包
        for (int num:nums)
        {
            for (int i=target;i>=num;i--)
            {
                dp[i] |=dp[i-num];
            }
        }
        return dp[target];
    }
}

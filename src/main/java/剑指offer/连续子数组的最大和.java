package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/16 下午7:14
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-16 19:14
 */
public class 连续子数组的最大和 {

    public int FindGreatestSumOfSubArray(int[] array) {

        int n=array.length;
        //dp[i]代表以arr[i]结尾的数组最大值
        int[] dp=new int[n+1];
        dp[0]=array[0];
        int res=dp[0];
        for (int i=1;i<n;i++)
        {
            dp[i]=Math.max(dp[i-1]+array[i],array[i]);
            res=Math.max(dp[i],res);
        }
        return res;



    }
}

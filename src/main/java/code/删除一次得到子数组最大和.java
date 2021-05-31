package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/27 下午6:56
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-27 18:56
 */
public class 删除一次得到子数组最大和 {
    public int maximumSum(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return 0;
        }
        //dp[i][0]代表没有删除元素的最大数值
        // dp[i][1]代表删除一个元素的最大和
        int[][] dp = new int[n][2];

        dp[0][0]=arr[0];
        dp[0][1]=0;
        int res=dp[0][0];

        for (int i = 1; i < n; i++) {

            dp[i][0]=Math.max(arr[i],dp[i-1][0]+arr[i]);
            //删除一个元素过后
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]+arr[i]);
            res=Math.max(Math.max(dp[i][0],dp[i][1]),res);

        }

        return res;

    }

    @Test
    public void test()
    {
        int[] arr ={1,-2,0,3};
        int res=maximumSum( arr);
        System.out.println(res);
    }
}

package code.数字问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/6 下午4:15
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-06 16:15
 */
public class 丑数 {
    public boolean isUgly(int num) {

        if (num < 1) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int nthUglyNumber(int n) {

        int a = 0, b = 0, c = 0;
        //
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            //dp[a]代表有a-1次乘2，
            int n2=dp[a]*2;
            int n3=dp[b]*3;
            int n5=dp[c]*5;
            //新的数一定是乘其中一个，则dp[i]，取最小
            dp[i]=Math.min(Math.min(n2,n3),n5);
            if (dp[i]==n2)
            {
                a++;
            }
            //意思是，新的数是乘3得到，则乘3的个数增加1
            if (dp[i]==n3)
            {
                b++;
            }
            //如果新数可以通过乘3或者乘5得到，则都++
            if (dp[i]==n5)
            {
                c++;
            }


        }
        return dp[n-1];

    }
    @Test
    public void test()
    {
        int res=nthUglyNumber(10);
        System.out.println(res);
    }
}

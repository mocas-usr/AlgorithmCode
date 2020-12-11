package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/9 上午10:32
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-09 10:32
 */
public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        //转换成字符数组
        String str=String.valueOf(num);
        char[] chars=str.toCharArray();

        //动态规划
        //dp代表i位置可以获得的字符串翻译个数
        int[] dp=new int[str.length()+1];
        dp[0]=1;//在第一个字符串之前
        dp[1]=1;//第一个字符串
        for (int i=2;i<=str.length();i++)
        {
            int index=Integer.valueOf(str.substring(i-2,i));
            if (index>=10 &&index<=25)
            {
                dp[i]=dp[i-1]+dp[i-2];
            }
            else
            {
                dp[i]=dp[i-1];
            }

        }
        return dp[str.length()];
    }

    @Test
    public void test()
    {
        int num=25;
        translateNum(num);
    }
}

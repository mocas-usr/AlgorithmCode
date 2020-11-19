package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/9 上午10:38
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-09 10:38
 */
public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        //转化成字符串
        String numStr=String.valueOf(num);
        int[] dp=new int[numStr.length()+1];
        dp[0]=1;//这是在第一个字符串之前，
        dp[1]=1;
        for (int i=2;i<=numStr.length();i++)
        {
            int n=Integer.valueOf(numStr.substring(i-2,i));
            if (n<26 &&n>=10)
            {
                dp[i]=dp[i-1]+dp[i-2];
            }
            else {
                dp[i]=dp[i-1];
            }

        }
        return dp[numStr.length()];
    }

    @Test
    public void test()
    {
        int num=12258;
        translateNum(num);
    }
}

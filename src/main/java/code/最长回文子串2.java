package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/25 上午11:17
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-25 11:17
 */
public class 最长回文子串2 {
    //暴力匹配 （Brute Force）
    public String longestPalindrome(String s)
    {
        //字符为空或者是1个时，则返回空或者1
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen=1;
        int begin=0;
        char[] s1=s.toCharArray();//转换成数组判断是否相等
        for (int i=0;i<len-1;i++)
        {
            for (int j=i+1;j<len;j++)
                if (j-i+1>maxLen &&valid(s1,i,j))
                {
                    maxLen=j-i+1;
                    begin=i;
                }
        }
        return s.substring(begin,begin+maxLen);
    }

    //判断数组是否相等
    public boolean valid(char[] s1,int left,int right)
    {
        while (left<right)
        {
            if (s1[left]!=s1[right])
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //动态规划
    public String longestPalindrome2(String s)
    {
        //特殊情况判别
        int n=s.length();
        if (n<2)
        {
            return s;
        }

        //dp动态规划
        Boolean[][] dp=new Boolean[n][n];
        //[i,j]=true,代表i，j范围是回文字符串
        for (int i=0;i<n;i++)
        {
            dp[i][i]=true;
        }
        //分割字符串
        char[] chars=s.toCharArray();
        int maxLen=1;
        int begin=0;
        for (int j=1;j<n;j++)
        {
            for (int i=0;i<j;i++)
            {
                //判断dp
                if (chars[i]!=chars[j])
                {
                    //如果首位不等，则直接false
                    dp[i][j]=false;
                }else
                {
                    //首尾相等，继续判断
                    //[i+1,j-1]长度小于2时，则说明到达临界
                    if (j-i<3)
                    {
                        dp[i][j]=true;
                    }
                    else
                    {
                        dp[i][j]=dp[i+1][j-1];//和上一级有关
                    }
                }
                if (dp[i][j] && j-i+1>maxLen)
                {
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);

    }
    //中心扩展算法
    public String longestPalindrome3(String s)
    {
        int len=s.length();
        if (len<2)
        {
            return s;
        }

        int maxLen=0;
        int begin=0;
        char[] chars=s.toCharArray();
        for (int i=0;i<len;i++)
        {
            //从中心拓展，最多拓展长度
            int len1=expand(chars,i,i);
            int len2=expand(chars,i,i+1);
            int length= Math.max(len1,len2);
            if (length>maxLen)
            {
                maxLen=length;
                begin=i-(length-1)/2;
            }

        }
        return s.substring(begin,begin+maxLen);
    }

    public int expand(char[] chars,int left,int right)
    {
        while (left>=0&& right<chars.length&&chars[left]==chars[right] )
        {

            //左右扩展
            left--;
            right++;
        }
        int len=right-left-1;//特别注意
        return len;

    }
    @Test
    public void test()
    {
        String s= "babad";
        longestPalindrome3(s);
    }
}

package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/25 上午9:24
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-25 09:24
 */
public class 最长回文子串 {

    public String longestPalindrome(String s) {
        if (s.length()==1)
        {
            return s.substring(0,1);
        }
        if (s.length()==0)
        {
            return  "";
        }

        int maxLength=Integer.MIN_VALUE;
        String s1="";
        int len=0;
        int k=0;
        int t=0;
        for (int i=0;i<s.length();i++)
        {
            //对称也是回文
            if (i<s.length()-1&&s.charAt(i)==s.charAt(i+1))
            {
                k=i;
                t=i+1;
                len=0;
                while (k>=0 &&t<s.length() &&s.charAt(k)==s.charAt(t) )
                {
                    //长度计算
                    len=len+2;
                    k--;
                    t++;
                }

            }
            //如果不等于i+2的，说明i+1不是回文中心
            else if (i<s.length()-2&&s.charAt(i)==s.charAt(i+2))
            {
                k=i;
                t=i+2;
                len=1;
                while (k>=0 &&t<s.length() &&s.charAt(k)==s.charAt(t) )
                {
                    //长度计算
                    len=len+2;
                    //保持不越界
                    k--;
                    t++;

                }
            }

            else
            {
                continue;
            }
            //长度大于原本的
            if (len>maxLength)
            {
                s1=s.substring(++k,t);//结果回文串
                maxLength= len;
            }
            else
            {
                continue;
            }
        }
        if (len==0){
            return s.substring(0,1);
        }
        return s1;

    }

    @Test
    public void test()
    {
        String s="babad";
        longestPalindrome(s);
    }
}

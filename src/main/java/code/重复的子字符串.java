package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/27 下午4:12
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-27 16:12
 */
public class 重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        if (n==0)
        {
            return false;
        }
        //i代表重复字符串长度
        for (int i=1;i<=n/2;i++)
        {
            //只有被整除才符合条件
            if (n%i==0)
            {
                String s1=s.substring(0,i);//子字符串
                String sum="";
                for (int j=0;j<n/i;j++)
                {
                    sum=sum+s1;
                }
                if (sum.equals(s))
                {
                    return true;
                }

            }
            else
            {

            }
        }
        return false;

    }

    @Test
    public void test()
    {
        String s="abab";
        repeatedSubstringPattern(s);
    }
}

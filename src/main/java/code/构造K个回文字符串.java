package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/12 下午4:31
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-12 16:31
 */
public class 构造K个回文字符串 {
    public boolean canConstruct(String s, int k) {
        //统计字符串字符出现的个数
        int[] table=new int[26];

        //
        int n=s.length();
        for (char ch:s.toCharArray())
        {
            //统计所有字符数量
            table[ch-'a']++;
        }

        //统计奇数字符个数
        int count=0;
        //统计奇数次字符出现的种类数
        for (int i=0;i<26;i++)
        {
            //说明此字符出现的次数是奇数
            if ((table[i]&1)==1)
            {
                count++;
            }
        }

        if (k<=n && k>=count)
        {
            return true;
        }else
        {
            return false;
        }
    }

    @Test
    public void test()
    {
        String s="yzyzyzyzyzyzyzy";
        int k=2;
        canConstruct(s,2);
    }
}

package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/3 下午4:08
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-03 16:08
 */
public class 外观数列 {
    //递归
    public  String countAndSay(int n)
    {
        String s="";//用来描述上一个字符串
        StringBuilder str=new StringBuilder();//用来构建现在的字符串
        //终止条件
        if (n==1)
        {
            return "1";
        }
        //上一个字符串
        s=countAndSay(n-1);
        int len=s.length();
        int pre=0;
        int count=0;
        int i=0;
        for (;i<s.length();i++)
        {
           //如果不相等，则更新计数
            if(s.charAt(pre)!=s.charAt(i))
            {//如果不相等时，更新指针
                count=i-pre;
                str.append(count).append(s.charAt(pre));
                pre=i;

            }
            //相等则更新i
        }
        //如果更新到最后截止
        if (pre!=i)
        {
            count=i-pre;
            str.append(count).append(s.charAt(pre));
        }
        return str.toString();

    }

    @Test
    public void test()
    {
        String rs=countAndSay(6);
        System.out.println(rs);
    }
}

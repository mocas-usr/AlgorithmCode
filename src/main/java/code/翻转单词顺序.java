package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 上午10:01
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-14 10:01
 */
public class 翻转单词顺序 {
    public String reverseWords(String s) {
        //分割出字符串
        String[] str=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i=str.length-1;i>=0;i--)
        {
            if (!str[i].isEmpty())
            {
                sb.append(str[i]).append(' ');

            }
        }

        return sb.toString().trim();
    }
    @Test
    public void  test()
    {
        String s="a good   example";
        reverseWords(s);
    }
}

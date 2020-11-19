package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/16 下午4:42
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-16 16:42
 */
public class 左旋转字符串 {
    //取余
    public String reverseLeftWords(String s, int n) {
        int len=s.length();//字符长度
        int index=0;
        char[] result=new char[len];//结果

        for (int i=0;i<len;i++)
        {
            index=(i+len-n)%len;
            result[index]=s.charAt(i);
        }
        String res= String.valueOf(result);
        return res;


    }

    //反转
    public String reverseLeftWords2(String s, int n)
    {
        int len=s.length();//字符长度
        char[] chars=s.toCharArray();
        //首先反转整个
        reverse(chars,0,len-1);
        reverse(chars,0,len-n-1);
        reverse(chars,len-n,len-1);
        return String.valueOf(chars);
    }

    //反转字符串
    public void reverse(char[] chars,int left,int right)
    {
        while (left<right)
        {
            char temp=chars[right];
            chars[right]=chars[left];
            chars[left]=temp;
            left++;
            right--;
        }
    }

    @Test
    public void test()
    {
        String s="abcdefg";
        int n=2;
        reverseLeftWords2(s,n);

    }
}

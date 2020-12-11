package code.字符串;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/4 下午4:37
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-04 16:37
 */
public class 最长不含重复字符的子字符串 {



    //双指针＋滑动窗口
    public int lengthOfLongestSubstring(String s) {

        //分割字符串
        char[] chars=s.toCharArray();

        int i=-1;
        int j=0;
        //用来保存此时的字符窗口
        Map<Character,Integer> map=new HashMap<>();
        int res=0;
        while (i<s.length() &&j<s.length())
        {
            if(map.containsKey(chars[j]))
            {
                //更新重复项目的位置
                i=Math.max(i,map.get(chars[j]));
            }

            //放进字符串统计
            map.put(chars[j],j);
            //i+1，j之间是没有重复项的
            res=Math.max(res,j-i);
            j++;
        }
        return res;
    }

    //动态规划
    public int lengthOfLongestSubstring2(String s)
    {
        if (s.length()==0)
        {
            return 0;
        }
       //dp代表第j个字符串的不重复字符串长度
        int dp=0;
        //存储字符串位置
        Map<Character,Integer> map=new HashMap<>();
        int res=0;
        char[] str=s.toCharArray();
        for (int i=0;i<s.length();i++)
        {
            char ch=str[i];
            int key=map.getOrDefault(ch,-1);

            //说明前一个字符串不包含现有字符ch
            if (i-key>dp)
            {
                dp=dp+1;
            }
            else
            {
                dp=i-key;
            }
            //取最大
            res=Math.max(res,dp);
            map.put(ch,i);
        }
        return res;

    }


    @Test
    public void test()
    {
        lengthOfLongestSubstring("12342");
    }


    public static void main(String[] args) {

    }
}

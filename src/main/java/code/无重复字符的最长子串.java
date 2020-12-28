package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/23 下午8:19
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-23 20:19
 */
public class 无重复字符的最长子串 {

    //动态规划

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0)
        {
            return 0;
        }
        int len=s.length();
        char[] str=s.toCharArray();//拆分字符串
        int dp=0;
        int res=0;
        //存储字符的位置
        Map<Character, Integer> map=new HashMap<>();
        for (int i=0;i<len;i++)
        {
            char ch=str[i];//此位的字符串
            int key=map.getOrDefault(ch,-1);
            if (i-key>dp)
            {
                dp=dp+1;
            }else
            {
                dp=i-key;
            }
            map.put(ch,i);
            res=Math.max(res,dp);
        }
        return res;

    }

    @Test
    public void test()
    {
        String s = "dvdf";
        int res=lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}

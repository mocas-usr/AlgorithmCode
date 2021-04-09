package code.滑动窗口;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/20 上午11:38
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-20 11:38
 */
public class 最长不含重复字符的子字符串 {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();

        //dp为包含当前字符的最大不重复长度
        int dp = 0;
        int n = s.length();
        char[] str = s.toCharArray();
        int res = 0;
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            //原本字符的位置
            int key = map.getOrDefault(c, -1);
            //不在上一个范围
            if (i - key > dp) {
                dp = dp + 1;
            } else {
                dp = i - key;
            }

            map.put(c, i);
            res = Math.max(res, dp);
        }
        return res;

    }

    //哈希表
    public int lengthOfLongestSubstring2(String s) {

        int leftIndex=-1;
        Map<Character,Integer> map=new HashMap<>();
        int res=0;
        char[] str=s.toCharArray();
        for (int i=0;i<str.length;i++)
        {
            char c=str[i];
            if (map.containsKey(c))
            {
                leftIndex=Math.max(leftIndex,map.get(c));

            }
            map.put(c,i);
            res=Math.max(res,i-leftIndex);

        }
        return res;
    }

    @Test
    public void test() {
        String s = "pwwkew";
        int res = lengthOfLongestSubstring2(s);
        System.out.println(res);
    }
}

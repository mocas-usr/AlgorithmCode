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

        int left = -1;
        int right = 0;

        int res = 0;
        char[] str = s.toCharArray();
        //[left+1,right]没有重复元素
        while (right < str.length) {
            //窗口扩增
            char curR = str[right];
            //窗口缩减
            if (map.containsKey(curR)) {
                left = Math.max(left, map.get(curR));
            }
            //当前窗口操作
            res = Math.max(res, right - left);
            map.put(curR, right);
            right++;
        }
        return res;
    }

    //哈希表
    public int lengthOfLongestSubstring2(String s) {

        int leftIndex = -1;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (map.containsKey(c)) {
                leftIndex = Math.max(leftIndex, map.get(c));

            }
            map.put(c, i);
            res = Math.max(res, i - leftIndex);

        }
        return res;
    }

    @Test
    public void test() {
        String s = "pwwkew";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}

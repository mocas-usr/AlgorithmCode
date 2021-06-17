package code.滑动窗口;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/2/1 22:19
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-02-01 22:19
 */
public class 找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new LinkedList<>();
        //记录字符情况
        int[] needs = new int[26];
        int[] windows = new int[26];
        //统计字符信息个数
        for (char c : p.toCharArray()) {
            //代表字符的个数
            needs[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        //拆分
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        while (right < s.length()) {
            //右边界的字符,代表字符的位置
            int curR = charS[right] - 'a';

            //统计右边界的字符出现次数
            windows[curR]++;
            //如果是比原有字符的个数多，则说明不对，移动左指针
            while (windows[curR] > needs[curR]) {
                int curL = charS[left] - 'a';
                left++;
                windows[curL]--;
            }

            if (right - left == p.length() - 1) {
                res.add(left);
            }
            //滑动窗口右边界
            right++;
        }
        return res;
    }

    @Test
    public void test() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = findAnagrams(s, p);
        System.out.println(res);
    }
}

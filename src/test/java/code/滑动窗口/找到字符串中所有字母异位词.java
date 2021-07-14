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
        char[] p1 = p.toCharArray();
        int[] needs = new int[26];

        //已经有的单词内容
        for (char ch : p1) {
            needs[ch - 'a']++;
        }

        int left = 0;
        int right = 0;
        char[] str = s.toCharArray();
        int n = str.length;
        int[] windows = new int[26];

        while (right < n) {
            char curR = str[right];
            //扩增窗口
            windows[curR - 'a']++;
            //缩减窗口
            while (windows[curR - 'a'] > needs[curR - 'a']) {
                char curl=str[left];
                windows[curl-'a']--;
                left++;
            }
            //当前选择
            if (right-left+1==p.length())
            {
                res.add(left);
            }

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

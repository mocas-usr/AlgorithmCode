package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/16 下午3:50
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-16 15:50
 */
public class 至少有K个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] cnt = new int[26];
        int n = s.length();

        if (n < k) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            cnt[str[i] - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            //肯定当前字符串不满足
            if (cnt[str[i]-'a']<k)
            {
                int l=longestSubstring(s.substring(0,i),k);
                int r=longestSubstring(s.substring(i+1,n),k);
                return Math.max(l,r);
            }
        }
        return n;
    }


    @Test
    public void test() {
        String s = "aaabb";
        int k = 3;
        int res = longestSubstring(s, k);
        System.out.println(res);
    }
}

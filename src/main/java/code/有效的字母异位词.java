package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/14 上午9:31
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-14 09:31
 */
public class 有效的字母异位词 {

    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        int[] count = new int[26];
        for (char c : s1) {
            count[c - 'a']++;
        }
        for (char ch : t1) {
            count[ch - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }

        }
        return true;

    }

    @Test
    public void test() {
       String s = "anagram";
       String t = "nagaram";
        boolean res=isAnagram(s, t);
        System.out.println(res);
    }
}

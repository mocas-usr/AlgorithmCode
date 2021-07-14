package code.计数;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/6 下午4:31
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-06 16:31
 */
public class 拼写单词 {
    public int countCharacters(String[] words, String chars) {

        char[] str = chars.toCharArray();
        int[] count = new int[26];
        for (char ch : str) {
            count[ch - 'a']++;
        }
        int res = 0;
        boolean flag = true;
        int[] num;
        for (String word : words) {
            flag = true;
            num = new int[26];
            char[] s = word.toCharArray();
            for (int i = 0; i < s.length; i++) {
                if (++num[s[i] - 'a'] > count[s[i] - 'a']) {
                    flag = false;
                    break;
                }

            }
            if (flag) {
                res += s.length;
            }
        }
        return res;


    }


    @Test
    public void test() {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        int res = countCharacters(words, chars);
        System.out.println(res);
    }
}

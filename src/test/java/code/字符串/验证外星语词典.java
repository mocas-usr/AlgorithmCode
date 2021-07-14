package code.字符串;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/4 下午3:32
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-04 15:32
 */
public class 验证外星语词典 {

    public boolean isAlienSorted(String[] words, String order) {

        int[] count = new int[26];

        int n = order.length();
        for (int i = 0; i < n; i++) {
            char ch = order.charAt(i);
            count[ch - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i + 1], count)) {
                return false;
            }
        }
        return true;

    }


    public boolean compare(String w1, String w2, int[] count) {
        //w1

        for (int i = 0; i < w1.length() && i < w2.length(); i++) {
            //w1在w2之前
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);
            if (count[c1 - 'a'] < count[c2 - 'a']) {
                return true;
            } else if (count[c1 - 'a'] > count[c2 - 'a']) {
                return false;
            } else {
                continue;
            }
        }
        //说明前面对比相等
        if (w1.length() > w2.length()) {
            return false;
        } else {
            return true;
        }
    }

    @Test
    public void test() {

        String[] words = {"my","f"};
        String order = "gelyriwxzdupkjctbfnqmsavho";
        boolean flag = isAlienSorted(words, order);
        System.out.println(flag);


    }
}

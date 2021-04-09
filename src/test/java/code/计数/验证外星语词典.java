package code.计数;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/6 下午4:32
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-06 16:32
 */
public class 验证外星语词典 {
    public boolean isAlienSorted(String[] words, String order) {

        boolean flag = false;
        int[] count = new int[order.length()];
        //英文字典排序
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            count[ch - 'a'] = i;
        }

        //排序
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            for (int j = 0; j < word1.length() && j < word2.length(); j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (count[ch1 - 'a'] <count[ch2 - 'a']) {
                    break;
                } else if (count[ch1 - 'a'] > count[ch2 - 'a']) {
                    return false;
                }else {
                    if (j == word1.length() - 1 && j < word2.length() - 1) {
                        return true;
                    }else if (j == word2.length() - 1 && j < word1.length() - 1){
                        return false;
                    }
                }
            }
        }
        return true;


    }

    @Test
    public void test() {
        String[] words = {"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        boolean flag = isAlienSorted(words, order);
        System.out.println(flag);


    }
}

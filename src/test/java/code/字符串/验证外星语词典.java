package code.字符串;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/4 下午3:32
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-04 15:32
 */
public class 验证外星语词典 {

    //
    public boolean isAlienSorted(String[] words, String order) {

        int[] orders = new int[26];
        //新的排序
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            orders[ch - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int min = Math.min(word1.length(), word2.length());

            for (int j = 0; j < min; j++) {
                if (orders[word1.charAt(j) - 'a'] > orders[word2.charAt(j) - 'a']) {
                    return false;
                } else if (orders[word1.charAt(j) - 'a'] < orders[word2.charAt(j) - 'a']) {
                    //这两个单词比较结果为true
                    break;
                }
                if (j == min - 1 && word1.length() > word2.length()) {
                    return false;
                } else {
                    continue;
                }
            }
        }

        return true;

    }
}

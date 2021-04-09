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

        char[] chars1 = chars.toCharArray();
        int[] chars2 = new int[26];
        //计数chars
        for (char ch : chars1) {
            chars2[ch - 'a']++;
        }

        int res = 0;
        //计数单词
        int[] num;
        for (String word : words) {
            num=new int[26];
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                num[ch - 'a']++;

                if (num[ch - 'a'] > chars2[ch - 'a']) {
                    break;
                }

                if (i==word.length()-1)
                {
                    res+=word.length();
                }
            }
        }
        return res;

    }


    @Test
    public void test() {
        String[] words={"cat","bt","hat","tree"};
        String chars="atach";
       int res= countCharacters(words,chars);
        System.out.println(res);
    }
}

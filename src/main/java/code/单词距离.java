package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/1 上午10:10
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-01 10:10
 */
public class 单词距离 {

    public int findClosest(String[] words, String word1, String word2) {

        int w1 = -1;
        int w2 = -1;
        int res = words.length + 1;
        int n = words.length;
        int i = 0;
        while (i < n) {
            if (words[i].equals(word1)) {
                w1 = i;
            } else if (words[i].equals(word2)) {
                w2 = i;
            }


            if (w1!=-1 && w2!=-1)
            {
                res=Math.min(res,Math.abs(w1-w2));
            }
            i++;

        }
        return res;
    }

    @Test
    public void test()
    {

    }


}

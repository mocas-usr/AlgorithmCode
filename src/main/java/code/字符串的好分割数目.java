package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/25 下午8:28
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-25 20:28
 */
public class 字符串的好分割数目 {

    public int numSplits(String s) {

        int n = s.length();

        //前n个字符长度
        int[] left = new int[n + 2];
        int[] right = new int[n + 2];

        boolean[] leftBool = new boolean[26];
        boolean[] rightBool = new boolean[26];


        for (int i = 1; i <= n; i++) {
            int ch = s.charAt(i - 1) - 'a';
            if (leftBool[ch]) {
                left[i] = left[i - 1];
            } else {
                leftBool[ch] = true;
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = n; i >= 1; i--) {
            int ch = s.charAt(i - 1) - 'a';
            if (rightBool[ch]) {
                right[i] = right[i + 1];
            } else {
                rightBool[ch] = true;
                right[i] = right[i + 1] + 1;
            }
        }

        //统计分割
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (left[i] == right[i + 1]) {
                res++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        String s = "aacaba";
        int res = numSplits(s);
        System.out.println(res);
    }
}

package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/3 上午11:09
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-03 11:09
 */
public class 恢复空格 {
    public int respace(String[] dictionary, String sentence) {
        Set<String> dict = new HashSet<>();
        for (String dic : dictionary) {
            dict.add(dic);
        }
        int n = sentence.length();
        //代表前i个字符包含的最少匹配数
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            //查看是否包含字典的单词
            for (String word : dictionary) {
                int wLen = word.length();
                if (i - wLen >= 0 && sentence.substring(i - wLen, i).equals(word)) {
                    dp[i] = Math.min(dp[i], dp[i - wLen]);
                }
            }
        }
        return dp[n];

    }
}

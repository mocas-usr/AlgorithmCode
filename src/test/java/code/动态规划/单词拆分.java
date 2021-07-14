package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/15 21:53
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashSet;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-01-15 21:53
 */
public class 单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();

        for (String str : wordDict) {
            set.add(str);
        }
        int n = s.length();
        //0到i个是否是可以拆分
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}

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
        HashSet<String> set = new HashSet<>(wordDict);
        int len = s.length();
        //代表截止到i的字符串是否能拆分
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        //拆分成0，j 还有j,i
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];


    }
}

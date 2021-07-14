package code.背包问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/9 下午8:14
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-09 20:14
 */
public class 单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();

        for (String word : wordDict) {
            set.add(word);
        }

        int n = s.length();
        //代表s.sub(0,i)能否拆分
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }

            }
        }
        return dp[n];

    }

    @Test
    public void test() {
        String s="leetcode";
        List<String> wordDict=new LinkedList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean res= wordBreak(s, wordDict);
        System.out.println(res);
    }
}

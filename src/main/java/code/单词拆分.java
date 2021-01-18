package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/14 19:45
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-14 19:45
 */
public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);//所有单词存储
        //dp[i]代表前i个s字符长度是否能有数组字符构成
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;//
        //i代表截取到s的第i个字符，从第一个字符开始
        for (int i=1;i<=s.length();i++)
            for (int j=0;j<i;j++)
            {
                if (dp[j] &&set.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }

        return dp[s.length()];

    }

    @Test
    public void test()
    {
        String s="catsandog";
        List<String> wordDict =new LinkedList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        boolean res=wordBreak(s,wordDict);
        System.out.println(res);
    }
}

package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/27 下午7:29
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-27 19:29
 */
public class 制造字母异位词的最小步骤数 {

    public int minSteps(String s, String t) {


        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int[] count=new int[26];
        for (char ch:s1)
        {
            count[ch-'a']++;
        }

        int res=0;
        for (char c:t1)
        {
            if (count[c-'a']==0){
                res++;
            }else
            {
                count[c-'a']--;
            }

        }

        return res;

    }

    @Test
    public void test() {
        String s = "leetcode";
        String t = "practice";
        int res=minSteps(s,t);
    }
}

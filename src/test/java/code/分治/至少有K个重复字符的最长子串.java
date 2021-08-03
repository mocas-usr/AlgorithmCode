package code.分治;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/16 下午4:29
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-16 16:29
 */
public class 至少有K个重复字符的最长子串 {

    public int longestSubstring(String s, int k) {


        char[] chars=s.toCharArray();

        int[] count=new int[26];
        for (char ch:chars)
        {
            count[ch-'a']++;
        }

        int n=s.length();
        for (int i=0;i<s.length();i++)
        {
            char c=chars[i];
            //下一路径
            if (count[c-'a']<k)
            {
                int left=longestSubstring(s.substring(0,i),k);
                int right=longestSubstring(s.substring(i+1,n),k);
                //当前选择
                return Math.max(left,right);

            }
        }
        return n;

    }
}

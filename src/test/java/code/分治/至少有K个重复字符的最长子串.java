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

        if (s.length() == 0) {
            return 0;
        }

        char[] str = s.toCharArray();
        int n = s.length();

        int[] count = new int[26];
        //计数里面字符的个数
        for (char ch : str) {
            count[ch - 'a']++;
        }

        //循环选择
        for (int i = 0; i < n; i++) {
            //当前选择
            //说明这个字符串不满足条件

            if (count[str[i]-'a']<k)
            {
                //下一路径
                int l=longestSubstring(s.substring(0,i),k);
                int r=longestSubstring(s.substring(i+1,n),k);
                return Math.max(l,r);

            }
        }

        return n;

    }
}

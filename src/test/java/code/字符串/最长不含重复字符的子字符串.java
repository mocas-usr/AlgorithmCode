package code.字符串;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/4 下午4:37
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-04 16:37
 */
public class 最长不含重复字符的子字符串 {


    //双指针＋滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int left = -1;
        int right = 0;

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        int res=0;
        for (int i = 0; i < s.length(); i++) {
            //如果包含新重复字符，则更新边界
            char ch = s.charAt(i);
            //i+1,right之间没有
            if (map.containsKey(ch)) {
                left=Math.max(left,map.get(ch));
            }
            map.put(ch,i);
            res=Math.max(res,i-left);
        }
        return res;
    }

    //动态规划
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //dp代表第j个字符串的不重复字符串长度
        int dp = 0;
        //存储字符串位置
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = str[i];
            int key = map.getOrDefault(ch, -1);

            //说明前一个字符串不包含现有字符ch
            if (i - key > dp) {
                dp = dp + 1;
            } else {
                dp = i - key;
            }
            //取最大
            res = Math.max(res, dp);
            map.put(ch, i);
        }
        return res;

    }


    @Test
    public void test() {
        lengthOfLongestSubstring("12342");
    }


    public static void main(String[] args) {

    }
}

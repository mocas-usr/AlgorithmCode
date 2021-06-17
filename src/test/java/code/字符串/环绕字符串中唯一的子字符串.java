package code.字符串;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/22 下午5:19
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-22 17:19
 */
public class 环绕字符串中唯一的子字符串 {
    //前缀和
    public int findSubstringInWraproundString(String p) {
        if (p.length() == 1) {
            return 1;
        }
        char[] chars = p.toCharArray();
        //记录每个以字母结尾的长度
        int[] count = new int[26];
        int len = chars.length;

        int curLen = 1;
        for (int i = 0; i < len; i++) {
            //这个时候是连续的和前一个
            if (i > 0 && (chars[i] - chars[i - 1] == 1 || chars[i - 1] - chars[i] == 25)) {
                //以当前字母结尾的长度+1
                curLen++;
            } else {
                //默认长度是1
                curLen = 1;
            }

            //求取字母结尾的最大长度
            count[chars[i] - 'a'] = Math.max(curLen, count[chars[i] - 'a']);
        }

        //这个注意，以字母结尾的最大长度就是个数
        int res = 0;
        for (int tmp : count) {
            res += tmp;
        }
        return res;
    }

    @Test
    public void test() {
        String p = "zab";
        int res = findSubstringInWraproundString(p);
        System.out.println(res);
    }
}

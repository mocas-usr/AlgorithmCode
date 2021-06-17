package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/9 上午10:32
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-12-09 10:32
 */
public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        if (len < 2) {
            return 1;
        }

        //第i个字符串
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        String s1 = str.substring(0, 2);
        int t = Integer.valueOf(s1);
        if (t > 25) {
            dp[2] = 1;
        } else if (t <= 25 && t >= 10) {
            dp[2] = 2;
        } else {
            dp[2] = 1;
        }

        for (int i = 3; i <= len; i++) {

            String s = str.substring(i - 2, i);
            int index = Integer.valueOf(s);
            if (index > 25) {
                dp[i] = dp[i - 1];
            } else if (index <= 25 && index >= 10) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];

    }

    @Test
    public void test() {
        int num = 12258;
        int res = translateNum(num);
        System.out.println(res);
    }
}

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

        if (num == 0) {
            return 1;
        }
        String s = String.valueOf(num);
        char[] str = s.toCharArray();
        int n = str.length;
        //0到第i个字符
        int[] dp = new int[str.length + 1];
        //第0个字符时
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= str.length; i++) {
            int num1 = Integer.valueOf(s.substring(i - 2, i));
            if (num1 >= 10 && num1 <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[n];
    }

    @Test
    public void test() {
        int num = 12258;
        int res = translateNum(num);
        System.out.println(res);
    }
}

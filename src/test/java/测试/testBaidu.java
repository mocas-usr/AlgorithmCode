package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/19 20:18
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-19 20:18
 */
public class testBaidu {
    //112268

    public int convert(String num) {

        char[] str = num.toCharArray();
        int n = str.length;
        //代表第i个字符的个数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //判断数值
            int num1 = Integer.parseInt(num.substring(i - 2, i));
            if (num1 == 10 || num1 == 20 ) {
                dp[i]=dp[i-2];
            } else if (num1 > 10 && num1 <= 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        String num = "101";
        int res = convert(num);
        System.out.println(res);

    }

}

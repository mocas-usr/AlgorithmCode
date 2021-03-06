package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/6 21:59
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Stack;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-01-06 21:59
 */
public class 最长有效括号 {
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        //

        int len = s.length();
        char[] str = s.toCharArray();
        //dp[i]代表截止到si位置的对称括号长度（包括si）
        int[] dp = new int[len];
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i < len; i++) {

            if (str[i] == ')') {
                //前一个的括号长度
                int preLen = dp[i - 1];
                int j = i - preLen - 1;
                if (j >= 0 && str[j] == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (j - 1 >= 0) {
                        dp[i] += dp[j - 1];
                    }
                } else {
                    dp[i] = 0;
                }
            }
            res = Math.max(res, dp[i]);

        }
        return res;
    }

    public int longestValidParentheses(String s) {

        //记录位置
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                //记录位置
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    //这里是无法构成括号
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    max = Math.max(max, len);

                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        String s = ")()())";
        int res = longestValidParentheses(s);
        System.out.println(res);
    }
}

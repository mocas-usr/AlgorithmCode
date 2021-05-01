package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/10 上午10:23
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Stack;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-10 10:23
 */
public class 基本计算器2 {

    public int calculate(String s) {
        //栈
        Stack<Integer> stack = new Stack<>();
        char preSign = '+';//数字前的运算符号
        char[] str = s.toCharArray();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {

            //如果是数字，不断确定数值
            if (Character.isDigit(str[i])) {
                num = num * 10 + Integer.valueOf(str[i] - '0');
            }
            if (!Character.isDigit(str[i]) && str[i] != ' ' || i == s.length() - 1) {
                //要看前一个运算符是什么
                if (preSign == '+') {
                    stack.push(num);
                } else if (preSign == '-') {
                    stack.push(-num);
                } else if (preSign == '*') {
                    int temp = stack.pop() * num;
                    stack.push(temp);
                } else if (preSign == '/') {
                    int temp = stack.pop() / num;
                    stack.push(temp);
                }
                num = 0;
                preSign = str[i];
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
        }
        return ans;
    }

    @Test
    public void test() {
        String s = "3+2 *2 ";
        int res = calculate(s);
        System.out.println(res);
    }
}

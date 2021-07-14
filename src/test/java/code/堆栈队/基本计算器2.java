package code.堆栈队;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/10 下午2:51
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Stack;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-10 14:51
 */
public class 基本计算器2 {

    public int calculate(String s) {

        //栈里面内容是相加和
        Stack<Integer> stack = new Stack<>();
        char preSign = '+';
        char[] str = s.toCharArray();
        int cur = 0;
        stack.push(0);
        int num = 0;
        while (cur < s.length()) {
            char ch = str[cur];
            //如果是数字
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            //在最后一个字符和新字符的情况下，进行结算
            if (!Character.isDigit(ch) &&ch!=' ' || cur==s.length()-1){

                if (preSign == '+') {
                    stack.push(num);
                } else if (preSign == '-') {
                    stack.push(-num);
                } else if (preSign == '*') {
                    num = stack.pop() * num;
                    stack.push(num);
                    num = 0;
                } else {
                    num = stack.pop() / num;
                    stack.push(num);
                    num = 0;
                }

                preSign = str[cur];
                num = 0;

            }



            cur++;
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();

        }
        return res;

    }


    @Test
    public void test() {

        int res = calculate(" 3+5 / 2 ");
        System.out.println(res);
    }
}

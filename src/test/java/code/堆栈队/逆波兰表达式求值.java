package code.堆栈队;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/15 下午7:15
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-15 19:15
 */
public class 逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {
            if (t.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.add(num2 + num1);
            } else if (t.equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.add(num2 - num1);
            } else if (t.equals("*")) {

                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.add(num2 * num1);
            } else if (t.equals("/")) {

                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.add(num2 / num1);
            } else {
                int num = Integer.valueOf(t);
                stack.add(num);
            }
        }
        return stack.peek();
    }
}

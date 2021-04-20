package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/12 上午11:39
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-12 11:39
 */
public class 逆波兰表达式求值 {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        int num1=0;
        int num2=0;
        int num=0;
        for (String s : tokens) {
            if (s.equals("+")) {
            num1=stack.pop();
            num2=stack.pop();
            num=num2+num1;
            stack.push(num);
            }else if (s.equals("-"))
            {
                num1=stack.pop();
                num2=stack.pop();
                num=num2-num1;
                stack.push(num);
            }else if (s.equals("*"))
            {
                num1=stack.pop();
                num2=stack.pop();
                num=num2*num1;
                stack.push(num);
            }else if (s.equals("/"))
            {
                num1=stack.pop();
                num2=stack.pop();
                num=num2/num1;
                stack.push(num);
            }else
            {
                num=Integer.valueOf(s);
                stack.push(num);
            }
        }

        return num;

    }
}

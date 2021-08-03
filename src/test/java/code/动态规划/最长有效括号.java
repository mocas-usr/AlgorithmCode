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

    public int longestValidParentheses(String s) {

        char[] str=s.toCharArray();
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int res=0;

        for (int i=0;i<s.length();i++)
        {
            if (str[i]=='(')
            {
                stack.push(i);
            }else {
                int top=stack.pop();
                //若为空。则不能构成
                if (stack.isEmpty())
                {
                    //把这个位置导入
                    stack.push(i);
                }else
                {
                  res=Math.max(res,i-stack.peek());
                }

            }
        }
        return res;
    }

    @Test
    public void test() {
        String s = ")()())";
        int res = longestValidParentheses(s);
        System.out.println(res);
    }
}

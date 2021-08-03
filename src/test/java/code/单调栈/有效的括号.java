package code.单调栈;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/20 上午9:47
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-20 09:47
 */
public class 有效的括号 {
    public boolean isValid(String s) {

        char[] str=s.toCharArray();

        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++)
        {
            if (str[i]=='(')
            {
                stack.push(')');
            }else if (str[i]=='{')
            {
                stack.push('}');
            }else if (str[i]=='[')
            {
                stack.push(']');
            }else
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                char ch=str[i];
                if (ch!=stack.pop())
                {
                    return false;
                }
            }

        }
        return stack.isEmpty();

    }
}

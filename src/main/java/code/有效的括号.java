package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/28 下午7:15
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-28 19:15
 */
public class 有效的括号 {
    public boolean isValid(String s) {

        //存储符号
        Stack<Character> stack=new Stack<>();
        char[] chars=s.toCharArray();//拆分字符串
        for (char c:chars)
        {
            //如果是左边，则压入右边的，等待对称出栈
            if (c=='(')
            {
                stack.add(')');
            }else if (c=='{')
            {
                stack.add('}');
            }else if (c=='[')
            {
                stack.add(']');
            }else if (stack.isEmpty())//如果直接压入的右边栈，
            {
                return false;
            }else if (c!=stack.pop())//压入右半边时，核对是否与左边对应
            {
                //出栈对应
                return false;

            }
        }
        return stack.isEmpty();
    }


    public boolean isValid2(String s) {
        if(s.length()==0) return true;
        Stack<Character> stack=new Stack<Character>(); //辅助栈
        for(char c:s.toCharArray()){
            if(c=='{') stack.push('}');  //如果是左符号，往栈中放入右符号
            else if(c=='[') stack.push(']');
            else if(c=='(') stack.push(')');
                //不是左边符号的情况，就是右边符号或者没有符号输入的情况；

                //如果栈中为空，也就是只有左边符号的情况；c!=pop()也就是左右不匹配。
            else if (stack.isEmpty()||c!=stack.pop())
                return false;
        }
        return stack.isEmpty();
    }

    @Test
    public void test()
    {
       String s= "([)]";
        isValid2(s);
        System.out.println(isValid(s));
    }
}

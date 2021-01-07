package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/5 20:10
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-05 20:10
 */
public class 最长有效括号 {
    public int longestValidParentheses(String s) {

        //如果字符串小于2，则直接0
        if (s==null ||s.length()<2)
        {
            return 0;
        }
        //dp i代表以i个字符结尾的最大有效括号
        int[] dp=new int[s.length()];
        int max=0;//结果
        for (int i=1;i<s.length();i++)
        {
            //如果是（，则默认dp[i]为0
            if (s.charAt(i)==')')
            {
                //上一个位置形成的括号长度
                int preLen=dp[i-1];
                int pre=i-preLen-1;
                //pre是对应这个括号的左括号位置
                if (pre>=0 &&s.charAt(pre)=='(')
                {
                    dp[i]=dp[i-1]+2;
                    //如果之前还有连续括号，则加上
                    if (pre-1>=0)
                    {
                        dp[i]+=dp[pre-1];
                    }
                }


                max=Math.max(max,dp[i]);
            }

        }

        return max;
    }

    //栈
    public int longestValidParentheses2(String s)
    {

        //如果字符串小于2，则直接0
        if (s==null ||s.length()<2)
        {
            return 0;
        }
        //利用栈记录下标
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);//先压入-1，做准备
        int max=0;
        //拆分字符串
        char[] str=s.toCharArray();
        //遍历
        for (int i=0;i<s.length();i++)
        {
            char ch=str[i];
            //左括号的情形
            if (ch == '(')
            {
                stack.push(i);
            }
            else//此时是）
            {
                //利用出栈来判别括号是否对称
                stack.pop();
                //这时如果是空，则说明此时不能构成连续括号

                if (stack.isEmpty())
                {
                    //到此是不能构成
                    stack.push(i);
                }
                else
                {
                    //此时说明构成连续括号
                    int len=i-stack.peek();
                    max=Math.max(max,len);

                }

            }


        }
        return max;
    }


    @Test
    public void test()
    {
        String s = "()()))))()()(";
        int num=longestValidParentheses(s);
        System.out.println(num);
    }
}

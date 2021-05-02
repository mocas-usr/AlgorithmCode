package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/1 上午11:17
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-01 11:17
 */
public class 计算器 {

    public int calculate(String s) {
        char[] str = s.toCharArray();

        char preSign = '+';
        Stack<Integer> stack = new Stack<>();
        int num=0;
        for (int i = 0; i < s.length(); i++) {

            //如果是数字
            if (Character.isDigit(str[i]))
            {
                num=num*10+Integer.valueOf(str[i]-'0');
            }
            //
            if (!Character.isDigit(str[i]) && str[i]!=' ' || i == s.length() - 1)
            {
                if (preSign=='+')
                {
                    stack.push(num);

                }else if (preSign=='-')
                {
                    stack.push(-num);
                }else if (preSign=='*')
                {
                    int temp=stack.pop();
                    stack.push(temp*num);
                }else if (preSign=='/')
                {
                    int temp=stack.pop();
                    stack.push(temp/num);
                }
                num=0;
                preSign=str[i];
            }

        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
        }
        return ans;


    }
}

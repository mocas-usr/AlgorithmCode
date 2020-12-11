package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/7 下午6:36
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-07 18:36
 */
public class 栈的压入弹出序列 {
    //模仿入栈
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //模仿栈
        Stack<Integer> stack=new Stack<>();

        int i=0;//出栈顺序
        //模仿入栈
        for (int num:pushed)
        {
            stack.add(num);
            while (!stack.isEmpty() && stack.peek()==popped[i])
            {
                stack.pop();
                i++;
            }
        }
        //如果为空，则为true
        return stack.isEmpty();

    }
}

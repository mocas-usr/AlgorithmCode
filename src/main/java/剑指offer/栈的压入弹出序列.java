package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 下午5:33
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-15 17:33
 */
public class 栈的压入弹出序列 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {

        Stack<Integer> stack=new Stack<>();

        int i=0;
        for (int num:pushA)
        {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek()==popA[i])
            {
                stack.pop();
                i++;
            }
        }
        if (stack.isEmpty())
        {
            return true;
        }else
        {
            return false;
        }
    }

}

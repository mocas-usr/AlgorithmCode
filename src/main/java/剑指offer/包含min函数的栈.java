package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 下午5:12
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 17:12
 */
public class 包含min函数的栈 {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int node) {

        s1.push(node);
        //空的时候，一定要保存
        if (s2.isEmpty())
        {
            s2.push(node);
        }else
        {
            if (node <= s2.peek()) {
                s2.push(node);
            }
        }


    }

    public void pop() {
        if (s1.isEmpty()) {
            return;
        }
        int num = s1.peek();
        if (num == s2.peek()) {
            s2.pop();
        }
        s1.pop();
    }

    public int top() {
        if (s1.isEmpty())
        {
            return -1;
        }
        return s1.peek();
    }

    public int min() {

        if (s1.isEmpty())
        {
            return -1;
        }
        return s2.peek();
    }
}

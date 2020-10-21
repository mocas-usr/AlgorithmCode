package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/17 下午3:19
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-17 15:19
 */
public class 用队列实现栈2 {

    //1个队列实现
    Queue<Integer> queue1;

    /**
     * Initialize your data structure here.
     */
    public void MyStack() {
        //初始化
        queue1 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    //重点内容
    public void push(int x) {
        //先获取原队列的长度
        int n = queue1.size();

        //将元素入队列
        queue1.offer(x);
        //再将新元素外的元素出队列，再入队列
        while (n > 0) {
            int t = queue1.poll();
            queue1.offer(t);
            n--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue1.poll();

    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue1.peek();

    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

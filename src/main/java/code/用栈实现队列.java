package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/17 下午2:29
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-17 14:29
 */
/*使用栈实现队列的下列操作：

        push(x) -- 将一个元素放入队列的尾部。
        pop() -- 从队列首部移除元素。
        peek() -- 返回队列首部的元素。
        empty() -- 返回队列是否为空。*/

public class 用栈实现队列 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /**
     * Initialize your data structure here.
     */
    public void MyQueue() {
        //初始化
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        //直接压入s1
        s1.push(x);

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        //s2是中转，
        //把s1出栈，压入s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        //s2是中转，
        //把s1出栈，压入s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();

    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {

        return s1.isEmpty() && s2.isEmpty();

    }
}

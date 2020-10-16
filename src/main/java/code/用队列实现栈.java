package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/16 下午4:39
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-16 16:39
 */
/*
使用队列实现栈的下列操作：

        push(x) -- 元素 x 入栈
        pop() -- 移除栈顶元素
        top() -- 获取栈顶元素
        empty() -- 返回栈是否为空
*/

public class 用队列实现栈 {
    //两个队列实现
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public void MyStack() {
        //初始化
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    /** Push element x onto stack. */
    //重点内容
    public void push(int x) {
        //q2入栈，q2作为中转栈
        queue2.offer(x);
        //q1出栈，入队q2
        while(!queue1.isEmpty())
        {
            queue2.offer(queue1.poll());
        }
        //交换que
        Queue q=new LinkedList();
        q=queue1;
        queue1=queue2;
        queue2=q;
        //此时q2是空，q1是入口队列


    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();

    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

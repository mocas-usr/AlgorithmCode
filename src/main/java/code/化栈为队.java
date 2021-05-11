package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/11 下午7:41
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-11 19:41
 */
public class 化栈为队 {
    class MyQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack1=new Stack<>();
            stack2=new Stack<>();

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);

        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }

            }
            if (!stack2.isEmpty())
            {
                return stack2.pop();
            }else
            {
                return -1;
            }

        }

        /** Get the front element. */
        public int peek() {
            if (stack2.isEmpty())
            {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (!stack2.isEmpty())
            {
                return stack2.peek();
            }else
            {
                return -1;
            }

        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if (stack2.isEmpty() &&stack1.isEmpty())
            {
                return true;
            }else
            {
                return false;
            }

        }
    }
}

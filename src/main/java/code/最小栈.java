package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/17 20:58
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-17 20:58
 */
public class 最小栈 {

    class MinStack {

        //双向队列
        Stack<Integer> stack;
        Deque<Integer> deque;

        /** initialize your data structure here. */
        public MinStack() {
            stack=new Stack<>();//用于保持入栈元素
            deque=new LinkedList<>();

        }

        //入栈
        public void push(int x) {
            stack.push(x);
            //入栈时，同时保持一个递增队列，队首大于队尾
            if (deque.isEmpty() ||x<=deque.peekLast())
            {
                deque.add(x);
            }



        }

        //正常出栈
        public void pop() {
            //如果出栈元素是最小的那个数，则deque也出队列
            if (stack.peek().equals(deque.peekLast()))
            {
                deque.pollLast();
            }
            stack.pop();
        }

        public int top() {

            return stack.peek();
        }

        public int getMin() {
            if (!deque.isEmpty())
            {
                return deque.peekLast();
            }
            return -1;

        }
    }
}

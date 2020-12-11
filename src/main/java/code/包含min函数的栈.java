package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/21 上午11:08
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-21 11:08
 */
public class 包含min函数的栈 {

    class MinStack {

        //辅助双向队列
        Deque<Integer> deque;
        Stack<Integer> stack;
        /** initialize your data structure here. */
        public MinStack() {
            stack=new Stack<>();
            deque=new LinkedList<>();
        }

        public void push(int x) {
            if (deque.isEmpty())
            {
                deque.add(x);
            }else
            {
                //保持双向队列从头到尾的递减
                if (deque.peekLast()>=x)
                {
                    deque.add(x);
                }
            }
            //入栈
            stack.push(x);

        }

        public void pop() {

            //如果出栈的是最小值
            if (stack.peek().equals(deque.peekLast()))
            {
                deque.pollLast();
            }
            stack.pop();

        }

        public int top() {
            return  stack.peek();


        }

        public int min() {
             return deque.peekLast();
        }
    }

    @Test
    public void test()
    {
        MinStack stack=new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
        stack.min();
        stack.pop();
        stack.min();
        stack.pop();
        stack.min();
    }


}

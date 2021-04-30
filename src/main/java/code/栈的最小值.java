package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/22 下午4:08
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-22 16:08
 */
public class 栈的最小值 {

    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack=new Stack<>();
            minStack=new Stack<>();

        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x<=minStack.peek())
            {
                minStack.push(x);
            }

        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            int num = stack.pop();
            if (num == minStack.peek())
            {
                minStack.pop();
            }

        }

        public int top() {

            if (minStack.isEmpty())
            {
                return  -1;
            }
            return stack.peek();

        }

        public int getMin() {
            return minStack.peek();

        }
    }
}

package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/19 下午7:11
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-19 19:11
 */
public class 栈排序 {

    class SortedStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        public SortedStack() {
            stack=new Stack<>();
            minStack=new Stack<>();
        }

        public void push(int val) {



            while (!stack.isEmpty() &&val>stack.peek())
            {
                int num=stack.pop();
                minStack.push(num);
            }
            stack.push(val);
            while (!minStack.isEmpty())
            {
                stack.push(minStack.pop());
            }



        }

        public void pop() {
            if (stack.isEmpty())
            {
                return;
            }
           stack.pop();

        }

        public int peek() {
            if (stack.isEmpty())
            {
                return -1;
            }
            return stack.peek();

        }

        public boolean isEmpty() {

            return stack.isEmpty();

        }
    }
}

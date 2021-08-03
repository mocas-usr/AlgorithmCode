package code.堆栈队;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/21 下午4:27
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-21 16:27
 */
public class 队列的最大值 {

    //这是队列和栈有区别
    class MaxQueue {

        //用于队列的最大数值
        Deque<Integer> deque;
        Queue<Integer> queue;

        public MaxQueue() {
            deque = new LinkedList<>();
            queue = new LinkedList<>();
        }

        public int max_value() {

            if (deque.isEmpty()) {
                return -1;
            } else {
                return deque.peekFirst();
            }

        }

        public void push_back(int value) {

            queue.add(value);
            while (!deque.isEmpty() && value > deque.peekLast()) {
                deque.pollLast();
            }
            deque.add(value);
        }

        public int pop_front() {
            if (queue.isEmpty())
            {
                return -1;
            }

            int num=queue.peek();
            if (num==deque.peek())
            {
                deque.pollFirst();
            }
            return queue.poll();
        }
    }
}

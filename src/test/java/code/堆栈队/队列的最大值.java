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

    class MaxQueue {

        Queue<Integer> queue;
        Deque<Integer> deque;

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            if (!deque.isEmpty()) {
                return deque.peekFirst();
            }else
            {
                return -1;
            }


        }

        public void push_back(int value) {

            queue.offer(value);
            while (!deque.isEmpty() && value >= deque.peekLast()) {
                deque.pollLast();
            }
            deque.offer(value);
        }

        public int pop_front() {
            if (!queue.isEmpty()) {
                int num = queue.peek();
                if (num == deque.peek()) {
                    deque.pollFirst();
                }

                return queue.poll();
            } else {
                return -1;
            }

        }
    }
}

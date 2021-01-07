package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/12 下午3:26
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-12 15:26
 */
public class 队列的最大值 {
    class MaxQueue {

        private Queue<Integer> queue;
        private Deque<Integer> deque;

        //初始化
        public MaxQueue() {
            //queue记录队列的 数值
            queue=new LinkedList<>();
            //deque记录队列最大值
            deque=new LinkedList<>();
        }
        //最大数值获取
        public int max_value() {
            if (queue.isEmpty())
            {
                return -1;
            }else
            {
                //首最大，是一个从大到小排列
               return deque.peek();

            }


        }

        public void push_back(int value) {
            //首先记录queue
            queue.offer(value);
            //处理deque
            //清除比val小的
            while (!deque.isEmpty() &&deque.peekLast()<value)
            {
                deque.pollLast();
            }
            //入队列
            deque.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty())
            {
                return -1;
            }
            int res=queue.poll();//此时队列首部出队
            if (res==deque.peek())
            {
                deque.poll();
            }
            return  res;
        }
    }

    @Test
    public void  test()
    {
        MaxQueue obj = new MaxQueue();
        int param_1 = obj.max_value();
        obj.push_back(1);
        obj.push_back(2);
        obj.push_back(4);
        obj.push_back(2);
        obj.push_back(0);
        obj.push_back(3);
        int param_3 = obj.pop_front();
    }

}

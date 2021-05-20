package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/16 上午10:40
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-16 10:40
 */
public class 连续中值 {
    class MedianFinder {

        Queue<Integer> max;
        Queue<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            min = new PriorityQueue<>((x, y) -> (y - x));
            max = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (min.size() != max.size()) {
                max.offer(num);
                min.offer(max.poll());
            } else {
                min.offer(num);
                max.offer(min.poll());
            }
        }

        public double findMedian() {
            if (min.size() != max.size()) {
                return max.peek();
            } else {
                double a = max.peek();
                double b = min.peek();
                return (a + b) / 2;
            }
        }
    }

    @Test
    public void test() {
        MedianFinder obj = new MedianFinder();
        obj.addNum(10);
        obj.addNum(8);
        obj.addNum(9);
        obj.addNum(7);
        double param_2 = obj.findMedian();
        System.out.println(param_2);
    }
}

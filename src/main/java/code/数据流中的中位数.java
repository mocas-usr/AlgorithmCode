package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/8 上午10:04
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-08 10:04
 */
public class 数据流中的中位数 {

    class MedianFinder {
        Queue<Integer> A;
        Queue<Integer> B;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            A = new PriorityQueue<>();
            B = new PriorityQueue<>((x, y) -> (y - x));
        }


        public void addNum(int num) {

            if (A.size() != B.size()) {
                //
                A.add(num);
                B.add(A.poll());

            } else {

                //b中的最大值放进A
                B.add(num);
                A.add(B.poll());
            }

        }

        public double findMedian() {

            if (A.size() != B.size()) {
                return (double)A.peek();
            } else {
                double a = A.peek();
                double b = B.peek();
                return (a + b) / 2;
            }

        }
    }

    @Test
    public void test() {
        MedianFinder obj=new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        double res=obj.findMedian();
        obj.addNum(3);
        double res2=obj.findMedian();
        System.out.println(res);

    }
}

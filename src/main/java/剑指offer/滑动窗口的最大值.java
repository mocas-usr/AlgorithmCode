package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 下午6:24
 * @email: wangyuhang_mocas@163.com
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 18:24
 */
public class 滑动窗口的最大值 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        if (num.length < size || size==0) {
            return new ArrayList<>();
        }
        Deque<Integer> deque = new LinkedList<>();
        //先初始化窗口
        for (int i = 0; i < size; i++) {

            while (!deque.isEmpty() && num[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(num[i]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(deque.peekFirst());

        //窗口移动
        for (int i = size; i < num.length; i++) {
            //说明队列已经满了
            if (num[i-size]==deque.peekFirst())
            {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && num[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(num[i]);
            res.add(deque.peekFirst());
        }
        return res;


    }
}

package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/17 下午3:48
 * @email: wangyuhang_mocas@163.com
 */

import java.util.PriorityQueue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-17 15:48
 */
/*
设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。

        你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
*/

public class 数据流中的第K大元素 {

    private PriorityQueue<Integer> priorityQueue;
    //队列元素个数
    int fix_k;

    public void KthLargest(int k, int[] nums) {
        fix_k = k;
        //堆队列保存k个有序数值，从小到大排列，首部小
        priorityQueue = new PriorityQueue<>(k);
        int n = nums.length;
        //将数值添加到堆队列，超长只会保留k个比较大的元素
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        int len = priorityQueue.size();
        //如果队列长度没超，继续添加
        if (len < fix_k) {
            priorityQueue.offer(val);
        } else {
            //判断是否大于最小的队首元素
            if (val > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(val);
            }

        }
        //返回第k大元素
        return priorityQueue.peek();
    }
}

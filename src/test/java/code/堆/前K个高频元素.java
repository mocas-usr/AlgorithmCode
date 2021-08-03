package code.堆;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/15 下午7:53
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-15 19:53
 */
public class 前K个高频元素 {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();


        //数值，频率
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //大顶堆
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>
                (((o1, o2) -> (o2.getValue().compareTo(o1.getValue()))));


        for (Map.Entry entry : map.entrySet()) {
            queue.add(entry);
        }


        int[] res = new int[k];
        for (int i=0;i<k;i++)
        {
            res[i]=queue.poll().getKey();
        }
        return res;


    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        System.out.println(res);
    }
}

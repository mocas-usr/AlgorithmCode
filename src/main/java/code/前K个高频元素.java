package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/14 下午4:03
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-14 16:03
 */
public class 前K个高频元素 {
    //堆排序
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue =new PriorityQueue<>(k,(x1, x2)->x2.getValue().compareTo(x1.getValue()));//大顶堆

        for(Map.Entry entry:map.entrySet()){
            queue.add(entry);
        }

        int []res=new int [k];
        for(int i=0;i<k;i++){
            res[i]=queue.poll().getKey();
        }
        return res;
    }

    @Test
    public void test()
    {
        int[] nums ={1,1,1,2,2,3};
        int  k = 2;
        int[] res=topKFrequent(nums, k);
        System.out.println(res);
    }
}

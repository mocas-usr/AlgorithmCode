package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 上午9:28
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 09:28
 */
public class 和为S的连续正数序列 {


    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        map.put(preSum, 0);
        //前缀和
        for (int i = 1; i < sum; i++) {
            preSum += i;
            map.put(preSum, i);
        }
        //找目标
        preSum = 0;
        for (int i = 0; i < sum; i++) {
            preSum += i;

            if (map.containsKey(sum + preSum)) {
                int j = map.get(sum + preSum);
                ArrayList<Integer> list = new ArrayList<>();
                for (int k = i+1; k <= j; k++) {
                    list.add(k);
                }
                res.add(new ArrayList<>(list));
            }

        }

        return res;


    }

    @Test
    public void test()
    {
        ArrayList<ArrayList<Integer>> res=FindContinuousSequence(3);
        System.out.println(res);
    }
}

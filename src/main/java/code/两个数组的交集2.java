package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/14 下午4:42
 * @email: wangyuhang_mocas@163.com
 */

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-14 16:42
 */
public class 两个数组的交集2 {
    public int[] intersect(int[] nums1, int[] nums2) {

        //记录次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);

        }

        List<Integer> list = new LinkedList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            } else {

            }
        }
        int[] res=new int[list.size()];

        for (int i=0;i<list.size();i++)
        {
            res[i]=list.get(i);
        }
        return res;
    }
}

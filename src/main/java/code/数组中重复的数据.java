package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/8 下午2:32
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-08 14:32
 */
public class 数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();

        int n=nums.length;

        for (int i = 0; i < nums.length; i++) {
            //出现一次的话不会超过n*2
            nums[(nums[i]-1)%n]+=n;
        }

        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]>2*n)
            {
                res.add(i+1);
            }

        }
        return res;
    }
}

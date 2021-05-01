package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/13 下午8:27
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-13 20:27
 */
public class 存在重复元素2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++)
        {
            if (map.containsKey(nums[i]))
            {
                int len=i-map.get(nums[i]);
                if (len<=k)
                {
                    return true;
                }
            }
            map.put(nums[i],i);



        }

        return false;
    }

    @Test
    public void test()
    {
        int[] nums ={1,0,1,1};
        int k = 1;
        boolean res= containsNearbyDuplicate(nums,k);
        System.out.println(res);
    }
}
